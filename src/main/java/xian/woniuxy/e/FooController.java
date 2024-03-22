package xian.woniuxy.e;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;


@Controller
@RequestMapping("foo")
public class FooController {

    @RequestMapping("f1")
    public ModelAndView f1(byte b, short s, int i, long l, float f, double d, boolean bb, char c, String str) {
        System.out.println("b = " + b);
        System.out.println("s = " + s);
        System.out.println("i = " + i);
        System.out.println("l = " + l);
        System.out.println("f = " + f);
        System.out.println("d = " + d);
        System.out.println("bb = " + bb);
        System.out.println("c = " + c);
        System.out.println("str = " + str);
        return new ModelAndView("e");
    }

    @RequestMapping("f2")
    public ModelAndView f2(User user) {
        System.out.println(user);
        return new ModelAndView("e");
    }

    @RequestMapping("f3")
    public ModelAndView f3(String[] hobby, String[] game) {
        System.out.println(Arrays.toString(hobby));
        System.out.println(Arrays.toString(game));
        return new ModelAndView("e");
    }


    @RequestMapping("f4")
    public ModelAndView f4(@RequestParam List<String> hobby) {
        System.out.println("FooController.f4: " + hobby);
        return new ModelAndView("e");
    }

    @RequestMapping("f5")
    public ModelAndView f5(@RequestParam Set<String> hobby) {
        System.out.println("FooController.f5: " + hobby);
        return new ModelAndView("e");
    }


    @RequestMapping("f6")
    public ModelAndView f6(@RequestParam Map<String, String> map) {
        System.out.println("FooController.f6: " + map);
        return new ModelAndView("e");
    }

}
