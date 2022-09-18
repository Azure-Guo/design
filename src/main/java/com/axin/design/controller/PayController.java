package com.axin.design.controller;

import com.axin.design.pay.pojo.PayBody;
import com.axin.design.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayController {
    @Autowired
    private PayService payService;

    @PostMapping("/pay")
    public Boolean pay(@RequestBody PayBody payBody){
        return payService.Pay(payBody);
    }
}
