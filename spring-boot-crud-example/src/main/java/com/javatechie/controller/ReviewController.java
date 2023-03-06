package com.javatechie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.model.Review;
import com.javatechie.repository.ProductRepository;
import com.javatechie.repository.ReviewRepository;

@RestController
public class ReviewController {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ReviewRepository reviewRepository;

	@GetMapping("/product/{id}/reviews")
	public List<Review> getProductReviews(@PathVariable int id) {
		if (!productRepository.existsById(id)) {
		      return null;
		}
		return reviewRepository.findByProductId(id);
	}
	
	@GetMapping("/review/{id}")
	public Review getReviewById(@PathVariable int id) {
		return reviewRepository.findById(id).orElse(null);
	}
	
	@PostMapping("/product/{id}/reviews")
	public String createReview(@PathVariable int id, @RequestBody Review newReview) {
		productRepository.findById(id).map(product -> {
			newReview.setProduct(product);
			return reviewRepository.save(newReview);
		}).orElse(null);
		
		return String.format("Successfully created review for product %d", id);
	}
	
	@DeleteMapping("/review/{id}")
	public void deleteReviewById(@PathVariable int id) {
		reviewRepository.deleteById(id);
	}
}
