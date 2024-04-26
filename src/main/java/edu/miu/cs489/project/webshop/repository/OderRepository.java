package edu.miu.cs489.project.webshop.repository;

import edu.miu.cs489.project.webshop.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OderRepository extends JpaRepository<Order, Integer> {



}
