package com.example.ordersys.controller;

import com.example.ordersys.mapper.UserMapper;
import com.example.ordersys.model.UserInfo;
import com.example.ordersys.tools.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
}
