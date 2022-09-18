package com.axin.design.pay.strategy;


import com.axin.design.pay.pojo.PayBody;

public interface PayStrategy {
    Boolean pay(PayBody payBody);
}
