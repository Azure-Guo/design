package com.axin.design.order.config;

import com.axin.design.order.pojo.Order;
import com.axin.design.order.pojo.OrderState;
import com.axin.design.order.pojo.OrderStateChangeAction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateMachineContext;
import org.springframework.statemachine.StateMachinePersist;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.persist.DefaultStateMachinePersister;
import org.springframework.statemachine.support.DefaultStateMachineContext;

import java.util.EnumSet;

@Configuration
@EnableStateMachine(name = "orderStateMachine")
public class OrderStateMachineConfig extends StateMachineConfigurerAdapter<OrderState, OrderStateChangeAction> {
    @Override
    public void configure(StateMachineStateConfigurer<OrderState, OrderStateChangeAction> states) throws Exception {
        states.withStates().initial(OrderState.ORDER_WAIT_PAY)
                .states(EnumSet.allOf(OrderState.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<OrderState, OrderStateChangeAction> transitions) throws Exception {
        transitions.withExternal().source(OrderState.ORDER_WAIT_PAY)
                .target(OrderState.ORDER_WAIT_SEND)
                .event(OrderStateChangeAction.PAY_ACTION)
                .and().withExternal()
                .source(OrderState.ORDER_WAIT_SEND)
                .target(OrderState.ORDER_WAIT_RECEIVE)
                .event(OrderStateChangeAction.SEND_ACTION)
                .and().withExternal()
                .source(OrderState.ORDER_WAIT_RECEIVE)
                .target(OrderState.ORDER_FINISH)
                .event(OrderStateChangeAction.RECEIVE_ACTION);
    }

    // 配置状态机持久化
    @Bean
    public DefaultStateMachinePersister machinePersister(){
        return new DefaultStateMachinePersister<>(new StateMachinePersist<Object,Object, Order>() {
            @Override
            public void write(StateMachineContext<Object, Object> stateMachineContext, Order order) throws Exception {
                // 持久化 redis mysql
            }

            @Override
            public StateMachineContext<Object, Object> read(Order order) throws Exception {
                // 本来应该从持久化里读取
                return new DefaultStateMachineContext(order.getOrderState(),null,null,null);
            }
        });
    }
}
