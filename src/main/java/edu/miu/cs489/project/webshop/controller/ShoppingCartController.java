package edu.miu.cs489.project.webshop.controller;

import edu.miu.cs489.project.webshop.service.ShoppingCartService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShoppingCartController {
    private ShoppingCartService cartService;
    public ShoppingCartController(ShoppingCartService cartService) {
        this.cartService = cartService;
    }





}
