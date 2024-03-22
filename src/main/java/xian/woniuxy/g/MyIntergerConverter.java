package xian.woniuxy.g;


import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class MyIntergerConverter implements Converter<String, Integer> {
    @Override
    public Integer convert(String s) {
        return Integer.valueOf(s) * 10;
    }
}
