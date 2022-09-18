package com.axin.design.pay.strategyFactory;

import com.axin.design.pay.strategy.PayStrategy;
import com.axin.design.pay.strategyEnum.StrategyEnum;

// 工厂类依靠策略枚举返回策略类
// 以后永远不需要修改factory,它是无状态的
public class StrategyFactory {
    public static PayStrategy getPayStrategy(StrategyEnum strategyEnum) {
        PayStrategy payStrategy = null;
        try {
            payStrategy = (PayStrategy) Class.forName(strategyEnum.getValue()).newInstance();
        }catch (Exception e){
            // 异常
        }
        return payStrategy;
    }
}
