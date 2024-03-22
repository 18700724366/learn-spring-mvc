package xian.woniuxy.ceshi;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {
        // 创建Spring上下文
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(RootConfig.class);
        // 获取calcImpl实例
        Calc c = (Calc) ctx.getBean("calcImpl");
        // 调用add方法
        c.add(6,10);
        System.out.println("==============");
        // 调用sub方法
        c.sub(6,10);
    }

}