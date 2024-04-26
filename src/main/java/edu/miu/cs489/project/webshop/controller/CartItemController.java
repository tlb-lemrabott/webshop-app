package edu.miu.cs489.project.webshop.controller;

import edu.miu.cs489.project.webshop.service.CartItemService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartItemController {
    private CartItemService cartItemService;
    public CartItemController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }




}
