package xian.woniuxy.l_restful;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gao
 * @date 2023/12/21 17:32:11
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResultVo {
    private int code;
    private String msg;
    private Object data;
}
