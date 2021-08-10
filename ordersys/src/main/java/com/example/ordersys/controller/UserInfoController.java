package com.example.ordersys.controller;

import com.example.ordersys.config.AppFinal;
import com.example.ordersys.mapper.UserMapper;
import com.example.ordersys.model.UserInfo;
import com.example.ordersys.tools.ResponseBody;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * ClassName:UserInfoController
 * Package:com.example.ordersys.controller
 * Description:
 *
 * @Author:HP
 * @date:2021/8/2 2:22
 */
@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Resource
    private UserMapper userMapper;

    /**
     * 用户注册
     * @return
     */
    @RequestMapping("/reg")
    public ResponseBody<Integer> register(UserInfo userInfo) {
        int data = userMapper.register(userInfo);
        return new ResponseBody<>(0,"",data);
    }

    /**
     * 查询所有用户列表
     * @return
     */
    @RequestMapping("/ulist")
    public ResponseBody<List<UserInfo>> getUserList() {
        List<UserInfo> data = new ArrayList<UserInfo>();
        data = userMapper.getUserList();
        return new ResponseBody<>(0,"",data);
    }

    /**
     * 登录功能
     * @param userInfo
     * @return
     */
    @RequestMapping("/login")
    public ResponseBody<UserInfo> login(UserInfo userInfo, HttpServletRequest req) {
        UserInfo user = userMapper.login(userInfo);
        if(user != null && user.getId() > 0) {
            HttpSession session = req.getSession();
            session.setAttribute(AppFinal.USERINFO_SESSIONKEY,user);
        }
        return new ResponseBody<>(0,"",user);
    }


    /**
     * 判断是否登录
     * @param req
     * @return
     */
    @RequestMapping("/islogin")
    public ResponseBody<UserInfo> isLogin(HttpServletRequest req) {
        UserInfo userInfo = null;
        HttpSession session = req.getSession(false);
        if(session != null && session.getAttribute(AppFinal.USERINFO_SESSIONKEY) != null) {
            userInfo = (UserInfo)session.getAttribute(AppFinal.USERINFO_SESSIONKEY);
        }
        return new ResponseBody<>(0,"",userInfo);
    }

    /**
     * 退出登录
     * @param req
     * @return
     */
    @RequestMapping("/logout")
    public ResponseBody<Integer> logout(HttpServletRequest req) {
        int data = 0;
        HttpSession session = req.getSession(false);
        if(session != null && session.getAttribute(AppFinal.USERINFO_SESSIONKEY) != null) {
            session.removeAttribute(AppFinal.USERINFO_SESSIONKEY);
            data = 1;
        }
        return new ResponseBody<>(0,"",data);
    }
}
