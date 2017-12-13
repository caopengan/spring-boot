package com.example.service.serviceImpl;

import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import com.example.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    private HttpServletRequest request;

    public List<User> getUserList(){
        List<User> userList = userRepository.findAll();
        return userList;
    }

    @Override
    public boolean createUser(User user) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String telphone = request.getParameter("telphone");
        user.setEmail(email);
        user.setName(email);
        user.setPassword(password);
        user.setCreateDate(DateUtil.getTimestamp());
        user.setTelphone(telphone);
        User u = userRepository.save(user);
        //用户创建成功之后，将用户信息保存在session中
        HttpSession session = request.getSession(true);
        session.setAttribute("userId",u.getId());
        session.setAttribute("userName",u.getName());
        return true;
    }


}
