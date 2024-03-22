package xian.woniuxy.h;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.Valid;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;


@Data
public class User {

    @Range(min = 1000, max = 10000, message = "id范围必须在 [1000, 10000] 之间")
    private Integer id;
    @Size(min = 2, max = 4, message = "name必须是2到4列")
    private String name;

    @Past(message = "你穿越回来买彩票的？")
    private Date birthday;

    private Double balance;

    @Pattern(regexp = "1[358]\\d{9}")
    private String cellphone;

    @Valid
    private Car car;
}