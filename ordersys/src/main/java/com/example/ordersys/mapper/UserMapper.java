package com.example.ordersys.mapper;

import com.example.ordersys.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * ClassName:UserMapper
 * Package:com.example.ordersys.mapper
 * Description:
 *
 * @Author:HP
 * @date:2021/8/2 2:27
 */
@Mapper
public interface UserMapper {
    //注册
    public int register(UserInfo userInfo);
}
