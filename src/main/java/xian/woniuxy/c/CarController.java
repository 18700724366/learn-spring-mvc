package xian.woniuxy.c;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("car")
public class CarController {

    @RequestMapping("save.do")
    public ModelAndView save() {
        System.out.println("CarController.save");
        return new ModelAndView("c");
    }

    @RequestMapping("delete")
    public ModelAndView delete() {
        System.out.println("CarController.delete");
        return new ModelAndView("c");
    }

//    @RequestMapping("save.do")
//    public ModelAndView f1() {
//        System.out.println("CarController.f1");
//        return new ModelAndView("c");
//    }
}
