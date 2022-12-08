package com.axin.design.service;

import com.axin.design.order.pojo.Order;
import com.axin.design.order.pojo.OrderState;
import com.axin.design.order.pojo.OrderStateChangeAction;
import com.axin.design.pay.facade.StrategyFacade;
import com.axin.design.pay.pojo.PayBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.persist.StateMachinePersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private StateMachine<OrderState, OrderStateChangeAction> stateMachine;
    @Autowired
    private StateMachinePersister<OrderState, OrderStateChangeAction, Order> stateMachinePersister;

    private List<Order> orders = new ArrayList<>();

    public Order createOrder(Integer id) {
        Order order = new Order();
        order.setOrderId(id);
        order.setOrderState(OrderState.ORDER_WAIT_PAY);
        // 入库
        orders.add(order); // 模拟存储到db
        return order;
    }

    // 将来我们删除或者增加修改任何付款的模块，无需修改service
    // 不会对调用层产生任何代码改动
    // 调用层我们的pay模块，无需关心任何实现的逻辑，直接将参数传给pay模块即可
    public Order pay(PayBody payBody) {
        boolean flag;
        flag = StrategyFacade.pay(payBody);
        if (flag) {
            //查库
            Order order = orders.get(0);
            Message<OrderStateChangeAction> message = MessageBuilder.
                    withPayload(OrderStateChangeAction.PAY_ACTION).
                    setHeader("order", order).build();
            // 发送消息,给谁,和状态机的关系
            if(changeStateAction(message,order)){
                saveToDb(payBody);
                return order;
            }
        }
        return null;
    }

    private void saveToDb(PayBody payBody) {
    }

    public Order send() {
        //查库
        Order order = orders.get(0);
        Message<OrderStateChangeAction> message = MessageBuilder.
                withPayload(OrderStateChangeAction.SEND_ACTION).
                setHeader("order", order).build();
        // 发送消息,给谁,和状态机的关系
        if(changeStateAction(message,order)){
            return order;
        }
        return null;
    }

    public Order receive() {
        //查库
        Order order = orders.get(0);
        Message<OrderStateChangeAction> message = MessageBuilder.
                withPayload(OrderStateChangeAction.RECEIVE_ACTION).
                setHeader("order", order).build();
        // 发送消息,给谁,和状态机的关系
        if(changeStateAction(message,order)){
            return order;
        }
        return null;
    }

    private boolean changeStateAction(Message<OrderStateChangeAction> message, Order order) {
        try {
            stateMachine.start();
            stateMachinePersister.restore(stateMachine, order);
            boolean res = stateMachine.sendEvent(message);
            stateMachinePersister.persist(stateMachine, order); // 状态机持久化
            return res;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            stateMachine.stop();
        }
        return false;
    }
}
