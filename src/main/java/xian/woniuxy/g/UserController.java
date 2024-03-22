package xian.woniuxy.g;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping("save")
    public String save(User user) {
        System.out.println(user);
        return "g";
    }
}
