package com.axin.design.pay.decorator;

import com.axin.design.pay.pojo.PayBody;
import com.axin.design.pay.strategyContext.AbstractPayContext;

public abstract class AbstractDecorator extends AbstractPayContext {
    // 装饰器类专门干装修的（平台币，红包）
    // 装饰的是谁
    private AbstractPayContext abstractPayContext = null;

    public AbstractDecorator(AbstractPayContext abstractPayContext) {
        this.abstractPayContext = abstractPayContext;
    }

    // 干活
    // 1.老活（支付）
    @Override
    public Boolean execute(PayBody payBody) {
        return abstractPayContext.execute(payBody);
    }
    // 2.新活(平台币，红包)
    public abstract void extraFunction(PayBody payBody);

    // 3.新活，老活的逻辑组装

}
