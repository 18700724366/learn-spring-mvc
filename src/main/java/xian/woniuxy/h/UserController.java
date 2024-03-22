package xian.woniuxy.h;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class UserController {

    @RequestMapping("user/save")
    public String save(@Validated User user, BindingResult result, Model model) {
        System.out.println(user);

        if (result.hasErrors()) {
            // 流程如果能进入这里，就说明，有错误！
            // 下面就是获取所有错误的方法：
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                model.addAttribute(fieldError.getField() + "Error", fieldError.getDefaultMessage());
            }
        }

        // 转发
        return "h";
    }


}