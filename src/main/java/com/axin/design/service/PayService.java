package com.axin.design.service;

import com.axin.design.pay.facade.StrategyFacade;
import com.axin.design.pay.pojo.PayBody;
import org.springframework.stereotype.Service;

@Service
public class PayService {
    // 将来我们删除或者增加修改任何付款的模块，无需修改service
    // 不会对调用层产生任何代码改动
    // 调用层我们的pay模块，无需关心任何实现的逻辑，直接将参数传给pay模块即可
    public Boolean Pay(PayBody payBody){
        boolean flag;
        flag = StrategyFacade.pay(payBody);
        if (flag) {
            saveToDb(payBody);
        }
        System.out.println("master修改");
        System.out.println("dev 修改");
        return flag;
    }

    private void saveToDb(PayBody payBody) {
    }
}
