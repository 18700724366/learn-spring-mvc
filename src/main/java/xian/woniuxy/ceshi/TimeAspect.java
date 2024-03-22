package xian.woniuxy.ceshi;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Aspect
@Order(0)
@Component
public class TimeAspect {
    // 定义一个切面，用于检查时间
    @Around("execution(* xian.woniuxy.ceshi.CalcImpl.*(..))")
    public Object checkTime(ProceedingJoinPoint joinPoint) throws Throwable {
        // 获取当前时间
        LocalTime currentTime = LocalTime.now();
        // 获取当前时间的分钟数
        int minute = currentTime.getMinute();
        // 判断分钟数是否为偶数
        if (minute % 2 == 0) {
            // 如果是偶数，则返回null
            System.out.println("当前时间的分钟是偶数");
            return null;
        }
        System.out.println("TimeAspect.checkTime");
        // 如果是偶数，则继续执行切点方法
        return joinPoint.proceed();
    }

}