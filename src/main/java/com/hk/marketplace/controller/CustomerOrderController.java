package com.hk.marketplace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hk.marketplace.entity.CustomerOrder;
import com.hk.marketplace.service.CustomerOrderService;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "*")
public class CustomerOrderController {

    @Autowired
    private CustomerOrderService orderService;

    @PostMapping
    public CustomerOrder createOrder(@RequestBody CustomerOrder order) {
        // return order;
        System.out.println(order);
        return orderService.placeOrder(order);
    }
}
