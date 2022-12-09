package com.axin.design.pay.decorator;

import com.axin.design.pay.pojo.PayBody;
import com.axin.design.pay.strategyContext.AbstractPayContext;

public class AddFuncDecorator extends AbstractDecorator {
    public AddFuncDecorator(AbstractPayContext abstractPayContext) {
        super(abstractPayContext);
    }

    @Override
    public void extraFunction(PayBody payBody) {
        String product = payBody.getProduct();
        // 从db里获取product详细信息
        // 从配置中心里获取产品的更新策略
        // 根据策略跟新用户平台币，或者红包
        System.out.println("更新平台币成功");
        System.out.println("发送红包模块成功");
    }

    @Override
    public Boolean execute(PayBody payBody) {
        Boolean execute = super.execute(payBody);//老活
        if (execute){
            this.extraFunction(payBody);//新活
        }else {
            // 补偿机制
        }
        return execute;
    }
}
