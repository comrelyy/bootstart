package com.springboot.bootstart.entity;

import java.util.Date;

public class OrderInfo {

    private Integer id;
    private Integer orderId;
    private Integer orderPrice;
    private Integer orderStatus;
    private Integer consigneeid;
    private Date createTime;
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Integer orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getConsigneeid() {
        return consigneeid;
    }

    public void setConsigneeid(Integer consigneeid) {
        this.consigneeid = consigneeid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", orderPrice=" + orderPrice +
                ", orderStatus=" + orderStatus +
                ", consigneeid=" + consigneeid +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
