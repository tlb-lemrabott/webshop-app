package edu.miu.cs489.project.webshop.service;

import edu.miu.cs489.project.webshop.repository.OderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private OderRepository orderRepository;
    public OrderService(OderRepository oderRepository) {
        this.orderRepository = oderRepository;
    }



}
