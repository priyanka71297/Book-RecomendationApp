package com.recommendation.RecomendationApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.recommendation.RecomendationApi.model.Author;
import com.recommendation.RecomendationApi.model.Book;
import com.recommendation.RecomendationApi.repository.AuthorRepository;

public abstract class AuthorServiceImpl implements AuthorService{

	@Autowired
	AuthorRepository authorRepository;
	
	
	public List<Author> getAllAuthors() {
		List<Author> authors = authorRepository.findAll();
		return authors;
	}
	
	

}
