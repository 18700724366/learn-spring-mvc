package xian.woniuxy.g;


import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Component
public class MyDateConverter implements Converter<String, Date>, ServletContextAware {

    private SimpleDateFormat sdf;

    @Override
    public Date convert(String s) {
        try {
            Date date = sdf.parse(s);
            // 这里返回的值，就是最终给目标的值
            return date;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        String dateFormat = servletContext.getInitParameter("dateFormat");
        this.sdf = new SimpleDateFormat(dateFormat);
    }
}
