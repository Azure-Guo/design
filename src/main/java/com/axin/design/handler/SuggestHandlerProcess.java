package com.axin.design.handler;

import com.axin.design.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SuggestHandlerProcess {
    @Value("#{'${suggest.requirement.handler}'.split(',')}")
    private List<String> handlers;

    public void process(UserInfo userInfo, List<String> suggestList) {
        // 如果想要实时的顺序调整和增减，必须使用配置中心进行配置
        for (String handler : handlers) {
            try {
                AbstractSuggestRequirementHandler handle =
                        (AbstractSuggestRequirementHandler)Class.forName(handler).newInstance();
                handle.processHandler(userInfo,suggestList);
            }catch (Exception e){

            }
        }
    }

}
