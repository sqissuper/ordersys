package com.example.ordersys.tools;

import lombok.Data;

/**
 * ClassName:ResponseBody
 * Package:com.example.ordersys.tools
 * Description:
 *
 * @Author:HP
 * @date:2021/8/2 2:23
 */
@Data
public class ResponseBody<T> {
    private int status;
    private String message;
    private T data;
    public ResponseBody(int status,String message,T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
