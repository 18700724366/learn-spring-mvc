package xian.woniuxy.l_restful;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author gao
 * @date 2023/12/21 17:31:36
 */
@Controller
@ResponseBody
public class UserController {

    @RequestMapping(value = "users", method = RequestMethod.POST)
    public ResultVo save(User user) {
        System.out.println("UserController.save: " + user);
        return new ResultVo(200, "save ok", null);
    }

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public ResultVo findAll() {
        List<User> list = new ArrayList<>();
        list.add(new User(1, "andy", new Date(), 3000d));
        list.add(new User(2, "eason", new Date(), 3000d));
        list.add(new User(3, "G.E.M", new Date(), 3000d));
        return new ResultVo(200, "ok", list);
    }

    @RequestMapping(value = "users", method = RequestMethod.PUT)
    public ResultVo update() {
        System.out.println("UserController.update");
        return new ResultVo(200, "update ok", null);
    }

    @RequestMapping(value = "users/{id}", method = RequestMethod.DELETE)
    public ResultVo delete(@PathVariable Integer id) {
        System.out.println("UserController.delete: " + id);
        return new ResultVo(200, "delete ok", null);
    }

}
