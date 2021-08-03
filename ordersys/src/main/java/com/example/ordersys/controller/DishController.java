package com.example.ordersys.controller;

import com.example.ordersys.mapper.DishMapper;
import com.example.ordersys.model.Dish;
import com.example.ordersys.tools.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;
/**
 * ClassName:DishController
 * Package:com.example.ordersys.controller
 * Description:
 *
 * @Author:HP
 * @date:2021/8/2 16:58
 */
@RestController
@RequestMapping("/dish")
public class DishController {

    @Resource
    private DishMapper dishMapper;

    /**
     * 订餐列表
     */
    @RequestMapping("/list")
    public ResponseBody<List<Dish>> getList() {
        List<Dish> data = dishMapper.getList();
        return new ResponseBody<>(0,"",data);
    }
}
