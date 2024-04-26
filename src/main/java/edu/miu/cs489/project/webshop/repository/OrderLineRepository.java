package edu.miu.cs489.project.webshop.repository;

import edu.miu.cs489.project.webshop.model.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepository extends JpaRepository<OrderLine, Integer> {
}
