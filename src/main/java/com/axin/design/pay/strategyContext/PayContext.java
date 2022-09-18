package com.axin.design.pay.strategyContext;

import com.axin.design.pay.pojo.PayBody;
import com.axin.design.pay.strategy.PayStrategy;

public class PayContext {
    private PayStrategy payStrategy;

    public PayContext(PayStrategy payStrategy) {
        this.payStrategy = payStrategy;
    }

    public Boolean execute(PayBody payBody){
        return this.payStrategy.pay(payBody);
    }
}
