package xian.woniuxy.e;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private int id;
    private String name;
    private Date birthday;
    private Double balance;
    private Car car;
}
