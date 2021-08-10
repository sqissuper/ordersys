package com.example.ordersys.mapper;

import com.example.ordersys.model.OrderInfo;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ClassName:OrderInfoMapper
 * Package:com.example.ordersys.mapper
 * Description:
 *
 * @Author:HP
 * @date:2021/8/7 23:22
 */
@Mapper
public interface OrderInfoMapper {
    public int add(OrderInfo orderInfo);

    public List<OrderInfo> getList(int uid);
}
