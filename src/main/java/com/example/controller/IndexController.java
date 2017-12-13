package com.example.controller;

import com.example.entity.User;
import com.example.push.WebSocketHander;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import com.example.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.socket.TextMessage;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@EnableAutoConfiguration
public class IndexController {

    @Autowired
    UserRepository userRepository;
    
    @Autowired
    UserService userService;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private WebSocketHander webSocketHander;

    @Autowired
    private User user;

    @RequestMapping("/index")
    public ModelAndView home(ModelMap modelMap){
        modelMap.addAttribute("msg","首页示例!");
        System.out.println("------------访问首页的controller");
//        List<User> userList = userRepository.findByAddress("天津");
        List<User> userList = userService.getUserList();
        modelMap.addAttribute("userList",userList);
//        modelMap.addAttribute("userName",request.getSession().getAttribute("userName"));
//        modelMap.addAttribute("userName","291033240@qq.com");
//        request.getSession().setAttribute("userName","291033240@qq.com");
//        modelMap.addAttribute("userList",userList);
        System.out.println("username=========="+request.getSession().getAttribute("userName"));
        return new ModelAndView("index", modelMap);
    }

    /**
     * 新建用户
     * @param modelMap
     * @return
     */
    @RequestMapping("/createUser")
    public String createUser(ModelMap modelMap){
        boolean result = userService.createUser(user);
        if(result){
            return "redirect:/index";
        }
        return "register";
    }


    @RequestMapping("/c")
    public String index(ModelMap modelMap){
        modelMap.put("msg","Spring boot ajax示例!");
//        User user = (User) userRepository.save(new User("曹鹏安", "男", 27, "天津",DateUtil.getTimestamp()));
//        System.out.println("保存用户==="+user);
        webSocketHander.sendMessageToUsers(new TextMessage(  "注册成功"));
        return "index";
    }

    @RequestMapping("/register")
    public String register(ModelMap modelMap){
//        modelMap.put("title","注册");
//        System.out.println("==========注册页面");
//        String header = request.getHeader("X-PJAX");
//        System.out.println("获取消息头信息=========="+header);
//        if(header == null){
//            return "redirect:/hello/";
//        }
        return "register";
    }


}
