package xian.woniuxy.l_restful;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author gao
 * @date 2023/12/19 10:49:12
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private int id;
    private String name;
    private Date birthday;
    private Double balance;
}
