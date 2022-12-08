package com.axin.design.order.pojo;

// 状态转换控制机。 初始化状态;配置状态转化的关系;持久化操作(redis)
public class Order {
    private Integer orderId;
    private OrderState orderState;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public OrderState getOrderState() {
        return orderState;
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }
}
