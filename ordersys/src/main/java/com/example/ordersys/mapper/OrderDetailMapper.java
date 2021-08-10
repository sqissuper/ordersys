package com.example.ordersys.mapper;

import com.example.ordersys.model.OrderDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ClassName:OrderDetailMapper
 * Package:com.example.ordersys.mapper
 * Description:
 *
 * @Author:HP
 * @date:2021/8/8 18:05
 */
@Mapper
public interface OrderDetailMapper {
    public int add(int oid,String[] dids);
    public List<OrderDetail> getList(int oid);
}
