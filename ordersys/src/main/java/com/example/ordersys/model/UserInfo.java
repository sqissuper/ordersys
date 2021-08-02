package com.example.ordersys.model;

import lombok.Data;

/**
 * ClassName:UserInfo
 * Package:com.example.ordersys.model
 * Description:
 *
 * @Author:HP
 * @date:2021/8/2 2:15
 */
@Data
public class UserInfo {
    private int id;
    private String username;
    private String password;
    private int isadmin;
}
