package edu.miu.cs489.project.webshop.controller;

import edu.miu.cs489.project.webshop.service.OrderService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    private OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }









}
