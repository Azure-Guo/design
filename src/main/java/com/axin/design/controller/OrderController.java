package com.axin.design.controller;

import com.axin.design.order.pojo.Order;
import com.axin.design.pay.pojo.PayBody;
import com.axin.design.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/create")
    public Order createOrder(@RequestParam Integer id) {
        return orderService.createOrder(id);
    }

    @PostMapping("/pay")
    public Order payOder(@RequestBody PayBody payBody){
        return orderService.pay(payBody);
    }

    @GetMapping("/send")
    public Order send() {
        return orderService.send();
    }

    @GetMapping("/receive")
    public Order receive() {
        return orderService.receive();
    }
}
