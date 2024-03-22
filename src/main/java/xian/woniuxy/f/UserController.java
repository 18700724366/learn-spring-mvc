package xian.woniuxy.f;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@Controller
@RequestMapping("user")
public class UserController {
    @RequestMapping("f1")
    public ModelAndView f1() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("f");

        // 以下代码，等价于: request.setAttribute("abc", "hahaha")
        mav.addObject("abc", "hahaha");
        return mav;

    }

    @RequestMapping("f2")
    public String f2(Model model) {
        // 以下代码，等价于: request.setAttribute("xx", "鱼香肉丝")
        model.addAttribute("xx", "鱼香肉丝");
        return "f";

    }


    @RequestMapping("f3.do")
    public String f3(int a, Model model) {

        model.addAttribute("user", "andy");

        if (a == 1) {
            // 这默认就是转发。
            return "f";
        } else {
            // 以下就是重定向
            return "redirect:/f.jsp";
        }
    }


    @RequestMapping("f4")
    public void f4(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, ServletException {

        ServletContext application = request.getServletContext();

        request.setAttribute("a", "关羽");
        session.setAttribute("b", "张飞");
        application.setAttribute("c", "赵云");

        // response.sendRedirect("/mvc/f2.jsp");
        request.getRequestDispatcher("/f2.jsp").forward(request, response);
    }
}
