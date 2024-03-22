package xian.woniuxy.k;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class Foo {

    @Around("execution(* xian.woniuxy.k.UserController.update(..))")
    public Object f1(ProceedingJoinPoint pjp) {
        try {
            System.out.println("前置通知");
            Object obj = pjp.proceed();
            System.out.println("返回通知");
            return obj;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("后置通知");
        }

    }


}
