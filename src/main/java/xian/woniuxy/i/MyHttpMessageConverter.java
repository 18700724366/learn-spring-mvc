package xian.woniuxy.i;

import java.io.*;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;


public class MyHttpMessageConverter extends AbstractHttpMessageConverter<User> {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

    @Override
    protected boolean supports(Class<?> clazz) {
        return User.class == clazz;
    }

    @Override
    protected User readInternal(Class<? extends User> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {

        try {
            InputStream in = inputMessage.getBody();
            ByteArrayOutputStream bout = new ByteArrayOutputStream();

            int n;
            while (in.available() > 0) {
                n = in.read();
                bout.write(n);
            }

            in.close();
            bout.close();

            byte[] bb = bout.toByteArray();
            String str = new String(bb);

            User user = clazz.newInstance();

            System.out.println("str = " + str);

            String[] entry = str.split("##");
            for (String s : entry) {

                String property = s.split("@")[0];
                String value = s.split("@")[1];
                Field f = clazz.getDeclaredField(property);
                f.setAccessible(true);
                if (f.getType() == Integer.class) {
                    f.set(user, new Integer(value));
                } else if (f.getType() == String.class) {
                    f.set(user, value);
                }

            }
            return user;


        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void writeInternal(User user, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        try {
            System.out.println("流程到此一游！！！");

            System.out.println("返回的值： user = " + user);

            StringBuilder sb = new StringBuilder();

            Class<? extends User> clz = user.getClass();

            Field[] fields = clz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                String fieldName = field.getName();
                Object filedValue = field.get(user);

                sb.append(fieldName);
                sb.append("@");

                if (field.getType() == Date.class) {
                    String time = sdf.format(filedValue);
                    sb.append(time);
                } else {
                    sb.append(filedValue);
                }

                sb.append("##");


            }
            sb.delete(sb.length() - 3, sb.length() - 1);


            OutputStream out = outputMessage.getBody();

            out.write(sb.toString().getBytes("utf-8"));

            out.close();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}