package com.recommendation.RecomendationApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recommendation.RecomendationApi.model.Author;

public interface AuthorRepository extends JpaRepository<Author,Integer>{

}
