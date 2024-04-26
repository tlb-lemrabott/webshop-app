package edu.miu.cs489.project.webshop.service;

import edu.miu.cs489.project.webshop.repository.OrderLineRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderLineService {
    private OrderLineRepository orderLineRepository;
    public OrderLineService(OrderLineRepository orderLineRepository) {
        this.orderLineRepository = orderLineRepository;
    }






}
