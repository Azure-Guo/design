package com.axin.design.handler;

import com.axin.design.pojo.UserInfo;

import java.util.List;

public class CityCheckHandler extends AbstractSuggestRequirementHandler{
    @Override
    public void processHandler(UserInfo userInfo, List<String> suggestList) {
        // 通过获取userinfo的city属性
        String city = userInfo.getCity();
        // 通过city和之前保留的4个业务信息进行对比，筛选出剩余的业务投放
        suggestList.remove("1");
    }
}
