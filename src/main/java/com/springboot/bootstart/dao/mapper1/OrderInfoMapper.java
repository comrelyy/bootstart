package com.springboot.bootstart.dao.mapper1;

import com.springboot.bootstart.entity.OrderInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Qualifier;

@Mapper
@Qualifier("db1SqlSessionFactory")
public interface OrderInfoMapper {

    @Insert("insert into tb_orderinfo(ORDERID,ORDER_PRICE,CONSIGNEEID,CREATE_TIME) values(${orderId},${orderPrice},${consigneeid},now())")
    void insert(OrderInfo info);

    @Select("select * from tb_orderinfo where ID=${id}")
    OrderInfo selectByPrimaryId(@Param("id") Integer id);
}
