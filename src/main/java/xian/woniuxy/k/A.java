package xian.woniuxy.k;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.Method;



@Component
public class A implements HandlerInterceptor {
    // 重写preHandle方法，在请求处理之前调用
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("A.preHandle");
        // 获取当前请求的处理器
        HandlerMethod h = (HandlerMethod) handler;
        // 获取当前请求的处理器方法
        Method method = h.getMethod();
        System.out.println("本次拦截到：" + method.getName() );
        // 获取当前请求的注解
        Abc annotation = method.getAnnotation(Abc.class);
        if (annotation == null) {
            System.out.println("方法上没有Abc注解，不放行");
            response.setContentType("text/html; charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.println("你没权限访问.. ");
            return false;
        }

        return true;
    }

    // 重写postHandle方法，在请求处理之后调用
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("A.postHandle");
    }

    // 重写afterCompletion方法，在请求处理之后调用
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("A.afterCompletion");
    }
}