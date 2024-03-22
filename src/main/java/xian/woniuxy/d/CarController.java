package xian.woniuxy.d;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("car")
public class CarController {

    @RequestMapping("save2")
    public ModelAndView save2() {
        System.out.println("CarController.save2");
        return new ModelAndView("c");
    }

    @RequestMapping("delete2")
    public ModelAndView delete2() {
        System.out.println("CarController.delete2");
        return new ModelAndView("c");
    }


}
