package edu.miu.cs489.project.webshop.service;

import edu.miu.cs489.project.webshop.repository.ShoppingCartRepository;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartService {
    private ShoppingCartRepository cartRepository;
    public ShoppingCartService(ShoppingCartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }





}
