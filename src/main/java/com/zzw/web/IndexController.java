package com.zzw.web;


import com.zzw.entity.User;
import com.zzw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/index")
public class IndexController {

    private UserService userService;

    /**
     * 构造依赖注入
     *
     * @param userService UserService
     */
    @Autowired
    public IndexController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {
        List<User> list = userService.getList();
        model.addAttribute("userList", list);
        return "user/index";
    }

    @RequestMapping(value = "/publish", method = RequestMethod.GET)
    public String publish(Model model) {
        String message = "提示: This is a tip.";
        model.addAttribute("msg", message);
        return "user/user-publish";
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String, Object> submit(HttpServletRequest request) {
        User user = new User();
        int code, err_code;
        String err_msg, data;

        user.setUserName(request.getParameter("username"));
        user.setNickName(request.getParameter("nickname"));
        user.setPasswd(request.getParameter("password"));
        // call service
        code = userService.addUser(user);

        err_code = (code + 1) % 2;
        err_msg = err_code == 0 ? "succeed" : "failed";
        data = "";
        HashMap<String, Object> map = new HashMap<>();
        map.put("err_code", err_code);
        map.put("err_msg", err_msg);
        map.put("data", data);
        return map;
    }

    @RequestMapping(value = "/{id}/detail", method = {RequestMethod.GET})
    public String detail(@PathVariable("id") Integer userId, Model model) {
        model.addAttribute("user", userService.getById(userId));
        return "user/user-detail";
    }

}
