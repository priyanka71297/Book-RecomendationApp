package com.recommendation.RecomendationApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recommendation.RecomendationApi.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
