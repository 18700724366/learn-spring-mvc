package xian.woniuxy.k;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class UserController {

    @Abc
    @RequestMapping("user/save")
    public String save() {
        System.out.println("UserController.save");
        return "k";
    }

    @RequestMapping("user/update")
    public String update() {
        System.out.println("UserController.update");
        return "k";
    }
}
