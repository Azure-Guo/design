package com.axin.design.handler;

import com.axin.design.pojo.UserInfo;

import java.util.List;

public class RecentCheckHandler extends AbstractSuggestRequirementHandler{
    @Override
    public void processHandler(UserInfo userInfo, List<String> suggestList) {
        // 近期购买产品
        List<String> buyProducts = userInfo.getBuyProducts();
        // 通过buyProducts ，筛选出剩余
        suggestList.remove("2");
    }
}
