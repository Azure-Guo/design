package com.axin.design.pay.strategyEnum;

public enum StrategyEnum {
    ZfbPayStrategy("com.axin.design.pay.strategy.ZfbStrategy"),
    WcPayStrategy("com.axin.design.pay.strategy.WcStrategy");
    String value = "";
    StrategyEnum(String value){
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
