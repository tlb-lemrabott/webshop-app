package edu.miu.cs489.project.webshop.controller;

import edu.miu.cs489.project.webshop.service.ReviewService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewController {
    private ReviewService reviewService;
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }






}
