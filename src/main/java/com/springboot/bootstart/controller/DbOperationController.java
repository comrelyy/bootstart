package com.springboot.bootstart.controller;

import com.springboot.bootstart.dao.mapper1.OrderInfoMapper;
import com.springboot.bootstart.dao.mapper2.UserInfoMapper;
import com.springboot.bootstart.entity.OrderInfo;
import com.springboot.bootstart.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/db")
public class DbOperationController {

    @Autowired
    private OrderInfoMapper orderInfoMapper;
    @Autowired
    private UserInfoMapper userInfoMapper;

    @RequestMapping("/insertUser")
    public @ResponseBody String insertUser(){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("lilu");
        userInfo.setPassWord("123456");
        userInfo.setPhoneNum("12345");
        userInfo.setEmail("lalalcom");
        userInfoMapper.insert(userInfo);
        return "true";
    }

    @RequestMapping("/getUserInfoById")
    public @ResponseBody UserInfo getUserInfoById(){
        UserInfo userInfo = userInfoMapper.selectByPrimaryId(1000006);
        return userInfo;
    }

    @RequestMapping("/insertOrder")
    public @ResponseBody String insertOrder(){
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderId(1);
        orderInfo.setOrderPrice(3);
        orderInfo.setConsigneeid(8683);
        orderInfoMapper.insert(orderInfo);
        return "true";
    }

    @RequestMapping("/getOrderInfoById")
    public @ResponseBody OrderInfo getOrderInfoById(){
        OrderInfo orderInfo = orderInfoMapper.selectByPrimaryId(1);
        return orderInfo;
    }
}
