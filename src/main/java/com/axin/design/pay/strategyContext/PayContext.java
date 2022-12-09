package com.axin.design.pay.strategyContext;

import com.axin.design.pay.pojo.PayBody;
import com.axin.design.pay.strategy.PayStrategy;

// 动态的给对象添加功能
// PayContext是被装饰者
// 所有我们用装饰者模式，被装饰者必须要有接口或者抽象类
public class PayContext extends AbstractPayContext{
    private PayStrategy payStrategy;

    public PayContext(PayStrategy payStrategy) {
        this.payStrategy = payStrategy;
    }

    public Boolean execute(PayBody payBody){
        return this.payStrategy.pay(payBody);
    }
}
