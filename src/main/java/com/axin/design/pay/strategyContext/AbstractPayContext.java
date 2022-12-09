package com.axin.design.pay.strategyContext;

import com.axin.design.pay.pojo.PayBody;

public abstract class AbstractPayContext {
    public abstract Boolean execute(PayBody payBody);
}
