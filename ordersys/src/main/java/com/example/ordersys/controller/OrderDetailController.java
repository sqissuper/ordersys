package com.example.ordersys.controller;

import com.example.ordersys.mapper.OrderDetailMapper;
import com.example.ordersys.model.OrderDetail;
import com.example.ordersys.tools.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClassName:OrderDetailController
 * Package:com.example.ordersys.controller
 * Description:
 *
 * @Author:HP
 * @date:2021/8/8 21:27
 */
@RestController
@RequestMapping("/detail")
public class OrderDetailController {
    @Resource
    private OrderDetailMapper orderDetailMapper;

    /**
     * 显示详情
     * @param oid
     * @return
     */
    @RequestMapping("/list")
    public ResponseBody<List<OrderDetail>> getList(int oid){
        List<OrderDetail> list = orderDetailMapper.getList(oid);
        return new ResponseBody<>(0,"",list);
    }
}
