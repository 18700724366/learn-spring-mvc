springmvc对restful风格的支持

0. 前置知识：默认Servlet

默认Servlet是配置在tomcat，安装目录下的conf/web.xml中，
    <servlet>
        <servlet-name>default</servlet-name>
        <servlet-class>org.apache.catalina.servlets.DefaultServlet</servlet-class>
        <init-param>
            <param-name>debug</param-name>
            <param-value>0</param-value>
        </init-param>
        <init-param>
            <param-name>listings</param-name>
            <param-value>false</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet>

    <servlet-mapping>
        <servlet-name>default</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>

    该默认Servlet的作用，就是用来找那些静态资源：图片 js css html

    比如，当我们发起一个请求： http://localhost:8080/mvc/1.gif, 服务器会拿着这个地址/1.gif，去找对应的servlet。
    只有找不到Servlet，才让DefaultServlet出来工作，DefaultServlet就是把1.gif当做静态文件寻找。找得到就响应该静态
    文件的2进制数据给客户端，找不到，就响应404。



1. 什么是rest
	a. representational state transfer 表现性状态转换
	b. rest是一种设计风格，是一种思想，而不是一种标准

2. 为什么使用restful
	不符合RESTFUL的URL
	增	http://127.0.0.1:8080/user/save.do		    请求方式:post
	删	http://127.0.0.1:8080/user/delete.do?id=1	请求方式:post
	改	http://127.0.0.1:8080/user/update.do		请求方式:post
	查	http://127.0.0.1:8080/user/findOne.do?id=1	请求方式:post
	查	http://127.0.0.1:8080/user/findAll.do		请求方式:post

	符合RESTFUL的URL
	增	http://127.0.0.1:8080/users			请求方式:post
	删	http://127.0.0.1:8080/users			请求方式:delete
	改	http://127.0.0.1:8080/users			请求方式:put
	查	http://127.0.0.1:8080/users/1		请求方式:get
	查	http://127.0.0.1:8080/users			请求方式:get

	其实，不符合RESTFUL的URL也是没有什么问题的，但是大神认为是有问题的，有什么问题呢？
	非RESTFUL的URL，查询的时候用了findOne或findAll，新增的时候用了save，其实完全
	没有这个必要! 因为http协议中已经提供了post、delete、put、get请求方式，程序员使
	用不同请求方式的意图很明显，完全没有必要做额外的描述，这就是为什么有了RESTFUL

    rest风格要求：
    1. url中不能有后缀
    2. url中不能出现动词
    3. url中只能出现名词，名词还必须是复数形式。
    4. 前后端交互时，传递的参数格式必须是 json 或 xml 格式。
    ..
    ..

    一个web应用，只要符合以上的风格要求，那就称这个web应用时restful风格的web应用。

3. springmvc中如何使用restful
	a. 前端控制器DispatcherServlet的映射路径改为/
		<servlet>
			<servlet-name>springDispatcherServlet</servlet-name>
			<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
			<init-param>
				<param-name>contextConfigLocation</param-name>
				<param-value>classpath:com/feicui/m_restful/applicationContext.xml</param-value>
			</init-param>
			<load-on-startup>1</load-on-startup>
		</servlet>
		<servlet-mapping>
			<servlet-name>springDispatcherServlet</servlet-name>
			<url-pattern>/</url-pattern>
		</servlet-mapping>

		注意/*与/的区别
		1) /* 在找不到资源的时候，会交给默认servlet来查找资源（tomcat内置的一个servlet）, 比如，针对于http://localhost:8080/foo/1.jpg这样的请求地址
		       如果找不到对应的servlet，则会交给默认servlet，默认servlet会在web应用根目录寻找名字叫做1.jpg的资源（而不是当作映射）
		2) / 就是默认servlet的映射路径，所以如果把DispatcherServlet设置为默认servlet，那么此时的这个默认servlet就只能把所有url中请求的资源当作映射路径了
		       针对于http://localhost:8080/foo/1.jpg这样的请求地址，找不见映射的话，那就是找不见，不会在从web应用根目录开始寻找了！
		3) / 什么都拦截，就是不拦截jsp请求，/*什么都拦截，包括jsp

	b. 静态资源映射
		<mvc:resources mapping="/js/**" location="/js/" ></mvc:resources>
		<mvc:resources mapping="/css/**" location="/css/" ></mvc:resources>
		<mvc:resources mapping="/images/**" location="/images/" ></mvc:resources>
	       或者直接把默认Servlet配置进来
	    <mvc:default-servlet-handler />

	c. 编写controller，注意：
		1) 在findOne方法中@PathVariable注解的使用，
		2) 且为了响应json格式的数据给客户端，需要完成以下两个步骤：
			a.导入jackjson-databind.jar
			b.在控制器方法加上@ResponseBody注解 ！

		@Controller
		@RequestMapping("/user")
		public class UserController {

			@RequestMapping(method = RequestMethod.POST)
			@ResponseBody
			public void save() {
				System.out.println("save...");
			}

			@RequestMapping(method = RequestMethod.DELETE)
			@ResponseBody
			public void delete() {
				System.out.println("delete...");
			}

			@RequestMapping(method = RequestMethod.PUT)
			@ResponseBody
			public void update() {
				System.out.println("update...");
			}

			@RequestMapping(value = "/{id}", method = RequestMethod.GET)
			@ResponseBody
			public void findOne(@PathVariable("id") int id) {
				System.out.println("findOne...:" + id);
			}

			@RequestMapping(method = RequestMethod.GET)
			@ResponseBody
			public void findAll() {
				System.out.println("findAll...");
			}
		}


	d. jsp页面看起来是这个样子:
		<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
		<!DOCTYPE html>
		<html>
			<head>
				<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
				<title>Insert title here</title>
				<script src="/springmvc/js/jquery-3.3.1.min.js"></script>
				<script>
					$(function() {
						$("#saveBtn").click(function() {
							$.ajax({
								type:"post",
								url:"/springmvc/user",
								cache:false,
								success:function() {
									alert("save success");
								}
							});
						});
						$("#deleteBtn").click(function() {
							$.ajax({
								type:"post",
								data:{
									_method:"delete"
								},
								url:"/springmvc/user",
								cache:false,
								success:function() {
									alert("delete success");
								}
							});
						});
						$("#updateBtn").click(function() {
							$.ajax({
								type:"post",
								data:{
									_method:"put"
								},
								url:"/springmvc/user",
								cache:false,
								success:function() {
									alert("update success");
								}
							});
						});
						$("#findOneBtn").click(function() {
							$.ajax({
								type:"get",
								url:"/springmvc/user/1",
								cache:false,
								success:function() {
									alert("findOne success");
								}
							});
						});
						$("#findAllBtn").click(function() {
							$.ajax({
								type:"get",
								url:"/springmvc/user",
								cache:false,
								success:function() {
									alert("findAll success");
								}
							});
						});

					});
				</script>
			</head>
			<body>

				<button id="saveBtn">save(post)</button>
				<button id="deleteBtn">delete(delete)</button>
				<button id="updateBtn">update(put)</button>
				<button id="findOneBtn">findOne(get)</button>
				<button id="findAllBtn">findAll(get)</button>

			</body>
		</html>

	e. 本来form只支持get和post请求方式，并不支持put和delete请求方式
	       但是springmvc框架提供了 "HiddenHttpMethodFilter过滤器" 来间接让表单支持put/delete请求
	     <filter>
			<filter-name>HiddenHttpMethodFilter</filter-name>
			<filter-class>org.springframework.web.filter.HiddenHttpMethodFilter</filter-class>
		</filter>

		<filter-mapping>
			<filter-name>HiddenHttpMethodFilter</filter-name>
			<url-pattern>/*</url-pattern>
		</filter-mapping>

	f. 此时，需要在表单中添加一个隐藏域，名字必须叫 "_method" ,其值可以是PUT/DELETE
	       如此，form表单就可以发起get、post、put、delete请求了!

4. restful最佳实践：restful是一种风格，而不是标准，所以每个公司都不一定是一样的。