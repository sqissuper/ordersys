package com.example.ordersys.controller;

import com.example.ordersys.config.AppFinal;
import com.example.ordersys.mapper.OrderDetailMapper;
import com.example.ordersys.mapper.OrderInfoMapper;
import com.example.ordersys.model.OrderInfo;
import com.example.ordersys.model.UserInfo;
import com.example.ordersys.tools.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * ClassName:OrderInfoController
 * Package:com.example.ordersys.controller
 * Description:
 *
 * @Author:HP
 * @date:2021/8/7 23:16
 */
@RestController
@RequestMapping("/order")
public class OrderInfoController {
    @Resource
    private OrderInfoMapper orderInfoMapper;

    @Resource
    private OrderDetailMapper orderDetailMapper;

    /**
     * 添加订单
     * @param dids
     * @param req
     * @return
     */
    @RequestMapping("/add")
    public ResponseBody<Integer> add(String dids, HttpServletRequest req) {
        int data = 0;
        HttpSession session = req.getSession(false);
        if(session != null && session.getAttribute(AppFinal.USERINFO_SESSIONKEY) != null) {
            int uid = ((UserInfo)session.getAttribute(AppFinal.USERINFO_SESSIONKEY)).getId();
            OrderInfo orderInfo = new OrderInfo();
            orderInfo.setUid(uid);
            int res = orderInfoMapper.add(orderInfo);
            if(res > 0) {
                data = orderDetailMapper.add(orderInfo.getId(),dids.split(","));
            }
        }
        return new ResponseBody<>(0,"",data);
    }


    /**
     * 订单显示
     * @param req
     * @return
     */
    @RequestMapping("/list")
    public ResponseBody<List<OrderInfo>> getList(HttpServletRequest req) {
        List<OrderInfo> list = null;
        HttpSession session = req.getSession(false);
        if(session != null && session.getAttribute(AppFinal.USERINFO_SESSIONKEY) != null) {
            int uid = ((UserInfo)session.getAttribute(AppFinal.USERINFO_SESSIONKEY)).getId();
            list = orderInfoMapper.getList(uid);
        }
        return new ResponseBody<>(0,"",list);
    }
}
