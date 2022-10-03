package com.axin.design.handler;

import com.axin.design.pojo.UserInfo;

import java.util.List;

public class PersonalCheckHandler extends AbstractSuggestRequirementHandler{
    @Override
    public void processHandler(UserInfo userInfo, List<String> suggestList) {
        // 通过个人资质的check,找到了4个可以投放的业务，放到suggestList 中
        suggestList.add("1");
        suggestList.add("2");
        suggestList.add("3");
        suggestList.add("4");
    }
}
