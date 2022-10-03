package com.axin.design.pay.facade;

import com.axin.design.pay.pojo.PayBody;
import com.axin.design.pay.strategy.PayStrategy;
import com.axin.design.pay.strategyContext.PayContext;
import com.axin.design.pay.strategyEnum.StrategyEnum;
import com.axin.design.pay.strategyFactory.StrategyFactory;


// 最终我们就暴露门面，对于里面所有的工厂。策略，策略枚举统统不暴露
// 门面就是我们超强的封装
public class StrategyFacade {
    // 定义一个map，将对应关系提前初始化
    public static Boolean pay(PayBody payBody) {
        // 获取我们的 策略枚举
        StrategyEnum strategyEnum = getStrategyEnum(payBody.getType());
        if (strategyEnum == null) {
            return false;
        }
        // 获取我们的策略对象
        PayStrategy payStrategy = StrategyFactory.getPayStrategy(strategyEnum);
        // 生成我们的策略上下文
        PayContext payContext = new PayContext(payStrategy);
        // 进行扣款
        payContext.execute(payBody);
        return true;
    }

    private static StrategyEnum getStrategyEnum(int type) {
        switch (type) {
            case 1:
                return StrategyEnum.ZfbPayStrategy;
            case 2:
                return StrategyEnum.WcPayStrategy;
            default:
                return null;
        }
    }
}
