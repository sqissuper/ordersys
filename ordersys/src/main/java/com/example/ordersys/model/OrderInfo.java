package com.example.ordersys.model;

import lombok.Data;

import java.util.Date;

/**
 * ClassName:OrderInfo
 * Package:com.example.ordersys.model
 * Description:
 *
 * @Author:HP
 * @date:2021/8/2 2:16
 */
@Data
public class OrderInfo {
    private int id;
    private int uid;
    private Date createtime;
    private int status;
}
