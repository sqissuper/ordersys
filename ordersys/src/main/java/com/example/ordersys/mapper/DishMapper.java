package com.example.ordersys.mapper;

import com.example.ordersys.model.Dish;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ClassName:DishMapper
 * Package:com.example.ordersys.mapper
 * Description:
 *
 * @Author:HP
 * @date:2021/8/2 17:02
 */
@Mapper
public interface DishMapper {
    public List<Dish> getList();
}
