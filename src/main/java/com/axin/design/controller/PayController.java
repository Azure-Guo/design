package com.axin.design.controller;

import com.axin.design.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayController {
    @Autowired
    private PayService payService;

    public Boolean pay(){
        return payService.Pay();
    }
}
