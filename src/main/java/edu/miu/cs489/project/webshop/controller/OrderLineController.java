package edu.miu.cs489.project.webshop.controller;

import edu.miu.cs489.project.webshop.service.OrderLineService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderLineController {
    private OrderLineService orderLineService;

    public OrderLineController(OrderLineService orderLineService) {
        this.orderLineService = orderLineService;
    }
}
