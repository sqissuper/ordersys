package com.example.ordersys.model;

import lombok.Data;

import java.math.BigDecimal;

/**
 * ClassName:Dish
 * Package:com.example.ordersys.model
 * Description:
 *
 * @Author:HP
 * @date:2021/8/2 2:18
 */
@Data
public class Dish {
    private int id;
    private String name;
    private BigDecimal price;
}
