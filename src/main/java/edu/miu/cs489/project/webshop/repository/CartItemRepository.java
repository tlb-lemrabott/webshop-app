package edu.miu.cs489.project.webshop.repository;

import edu.miu.cs489.project.webshop.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {



}
