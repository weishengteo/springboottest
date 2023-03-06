package com.javatechie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javatechie.model.Review;

import jakarta.transaction.Transactional;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
	List<Review> findByProductId(int id);
	  
	@Transactional
	void deleteByProductId(int id);
}
