package xian.woniuxy.i;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;


@Controller
public class UserController {

    @RequestMapping("user/save")
    public String save(User user) {
        System.out.println("user = " + user);
        return "i";
    }

    @RequestMapping("user/save2")
    public String save2(@RequestBody User user) {
        System.out.println("user = " + user);
        return "i";
    }

    @RequestMapping("user/save3")
    public String save3(@RequestBody String str) {
        System.out.println("str = " + str);
        return "i";
    }


    @RequestMapping("user/save4")
    @ResponseBody
    public User save4() {
        User user = new User();
        user.setId(123);
        user.setName("abc");
        user.setBirthday(new Date());
        user.setBalance(123.456d);
        return user;
    }

    @RequestMapping("user/save5")
    public User save5() {
        System.out.println("UserController.save5");
        User user = new User();
        user.setId(123);
        user.setName("abc");
        user.setBirthday(new Date());
        user.setBalance(123.456d);
        return user;
    }


    @RequestMapping("user/save6")
    @ResponseBody
    public String save6() {
        return "i";
    }


    @RequestMapping("user/save7")
    @ResponseBody
    public List save7() {
        List<String> list = Arrays.asList("andy bob clark dad eason".split(" "));
        return list;
    }


    @RequestMapping("user/save8")
    @ResponseBody
    public List save8() {
        List<User> list = new ArrayList<>();
        list.add(new User(1, "andy", new Date(), 1000d));
        list.add(new User(2, "andy2", new Date(), 2000d));
        list.add(new User(3, "andy3", new Date(), 3000d));
        list.add(new User(4, "andy4", new Date(), 4000d));
        return list;
    }


    @RequestMapping("user/save9")
    @ResponseBody
    public Set save9() {
        Set<User> set = new HashSet<>();
        set.add(new User(1, "andy", new Date(), 1000d));
        set.add(new User(2, "andy2", new Date(), 2000d));
        set.add(new User(3, "andy3", new Date(), 3000d));
        set.add(new User(4, "andy4", new Date(), 4000d));
        return set;
    }

    @RequestMapping("user/save10")
    @ResponseBody
    public Map save10() {
        Map<String, User> map = new HashMap<>();
        map.put("a", new User(1, "andy", new Date(), 1000d));
        map.put("b", new User(2, "andy2", new Date(), 2000d));
        map.put("c", new User(3, "andy3", new Date(), 3000d));
        map.put("d", new User(4, "andy4", new Date(), 4000d));
        return map;
    }


    @RequestMapping("user/save11")
    @ResponseBody
    public User save11() {
        User user = new User();
        user.setId(22);
        user.setName("刘德华");
        user.setBirthday(new Date());
        user.setBalance(1234D);
        return user;
    }


    @RequestMapping("user/save12")
    @ResponseBody
    public List save12(@RequestBody User user) {

        List<User> list = new ArrayList<>();
        list.add(new User(1, "abc", new Date(), 123d));
        list.add(new User(2, "xxx", new Date(), 123d));
        list.add(new User(3, "yyy", new Date(), 123d));
        list.add(user);

        return list;
    }
}
