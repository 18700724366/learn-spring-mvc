// 添加中文注释
package xian.woniuxy.k;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Abc {
    // 定义一个字符串类型的属性，默认值为空字符串
    String value() default "";
}