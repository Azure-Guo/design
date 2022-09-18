package com.axin.design.pay.strategy;


import com.axin.design.pay.pojo.PayBody;

public class WcStrategy implements PayStrategy{
    @Override
    public Boolean pay(PayBody payBody) {
        return true;
    }
}
