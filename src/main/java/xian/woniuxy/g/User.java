package xian.woniuxy.g;

import lombok.Data;

import java.util.Date;


@Data
public class User {
    private Integer id;
    private String name;
    private Date birthday;
    private Double balance;
}
