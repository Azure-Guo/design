package com.axin.design.pay.strategy;


import com.axin.design.pay.pojo.PayBody;

public class ZfbStrategy implements PayStrategy {
    @Override
    public Boolean pay(PayBody payBody) {
        // 第三方逻辑
        return true;
    }
}
