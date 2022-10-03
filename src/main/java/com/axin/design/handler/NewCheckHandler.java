package com.axin.design.handler;

import com.axin.design.pojo.UserInfo;

import java.util.ArrayList;
import java.util.List;

public class NewCheckHandler extends AbstractSuggestRequirementHandler{
    @Override
    public void processHandler(UserInfo userInfo, List<String> suggestList) {
        boolean newUser = userInfo.isNewUser();
        if (newUser) {
            // 特定的list
            suggestList = new ArrayList<>();
        }
    }
}
