package edu.miu.cs489.project.webshop.repository;

import edu.miu.cs489.project.webshop.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {




}
