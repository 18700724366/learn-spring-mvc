// 添加中文注释后
package xian.woniuxy.ceshi;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Aspect
@Order(1)
@Component
public class NumAspect {
    // 添加中文注释后
    @Around("execution(* xian.woniuxy.ceshi.CalcImpl.*(..))")
    public static Object checkParameters(ProceedingJoinPoint joinPoint) throws Throwable {
        // 获取方法参数
        Object[] args = joinPoint.getArgs();
        // 遍历参数，检查参数是否是奇数
        for (Object arg : args) {
            if (arg instanceof Integer && ((Integer) arg) % 2 != 0) {
                throw new RuntimeException("参数不能是奇数");
            }
        }
        System.out.println("NumAspect.checkParameters");
        // 执行方法
        return joinPoint.proceed();
    }


}