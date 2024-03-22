package xian.woniuxy.h;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class Car {
    @Length(min = 2, max = 6)
    private String brand;
    private String color;

}
