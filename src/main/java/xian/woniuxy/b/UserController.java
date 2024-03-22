package xian.woniuxy.b;


import org.springframework.web.HttpRequestHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserController implements HttpRequestHandler {
//    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("UserController.handleRequest!!!!");
        request.getRequestDispatcher("/b.jsp").forward(request, response);
    }


//    此方法是用Controller实现的
//    @Override
//    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        System.out.println("UserController.handleRequest");
//        return new ModelAndView("b");
//    }
}
