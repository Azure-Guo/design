package com.axin.design.pay.strategyFactory;

import com.axin.design.pay.strategy.PayStrategy;
import com.axin.design.pay.strategyEnum.StrategyEnum;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// 工厂类依靠策略枚举返回策略类
// 以后永远不需要修改factory,它是无状态的
public class StrategyFactory {
    private static final Map<String,PayStrategy> PAY_STRATEGY_MAP = new ConcurrentHashMap<>();
    public static PayStrategy getPayStrategy(StrategyEnum strategyEnum) {
        PayStrategy payStrategy = PAY_STRATEGY_MAP.get(strategyEnum.getValue());
        if (payStrategy==null){
            try {
                payStrategy = (PayStrategy) Class.forName(strategyEnum.getValue()).newInstance();
                PAY_STRATEGY_MAP.put(strategyEnum.getValue(),payStrategy);
            }catch (Exception e){
                // 异常
            }
        }
        return payStrategy;
    }
}
