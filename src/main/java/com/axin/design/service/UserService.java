package com.axin.design.service;

import com.axin.design.handler.SuggestHandlerProcess;
import com.axin.design.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private SuggestHandlerProcess suggestHandlerProcess;
    public List<String> suggestRequirement(String username) {
        // 获取用户信息, 因为用户已经登录了，那么user信息是保存在我们的缓存里的
        UserInfo userInfo = getUserInfo(username);
        List<String> results = new ArrayList<>();
        suggestHandlerProcess.process(userInfo,results);
        return results;
    }

    // 因为需要查询缓存，如果缓存没有，需要查库.本应在dao层，为了简便写这里
    private UserInfo getUserInfo(String username) {
        return new UserInfo();
    }
}
