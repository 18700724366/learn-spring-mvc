package xian.woniuxy.d;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("user")
public class UserController {
    @RequestMapping("save")
    public ModelAndView save() {
        System.out.println("UserController.save");
        return new ModelAndView("c");
    }

    @RequestMapping("delete")
    public ModelAndView delete() {
        System.out.println("UserController.delete");
        return new ModelAndView("c");
    }
}
