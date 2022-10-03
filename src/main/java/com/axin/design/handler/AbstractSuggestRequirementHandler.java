package com.axin.design.handler;

import com.axin.design.pojo.UserInfo;

import java.util.List;

public abstract class AbstractSuggestRequirementHandler {
    abstract void processHandler(UserInfo userInfo, List<String> suggestList);
}
