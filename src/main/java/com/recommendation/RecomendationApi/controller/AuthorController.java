package com.recommendation.RecomendationApi.controller;

import java.util.List;
import java.util.Optional;

//import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.recommendation.RecomendationApi.model.Author;

import com.recommendation.RecomendationApi.service.AuthorService;

@RestController
@RequestMapping("/user")
// @CrossOrigin(origins = "*")

public class AuthorController {

	@Autowired(required = false)
	AuthorService authorService;

	@GetMapping("/get-author-by-id/{id}")
	public ResponseEntity<Author> getAuthorById(@PathVariable(name = "id") int id) {

		Author author = authorService.getAuthorById(id);
		if (author == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(author));
	}

	@GetMapping("/get-all-authors")
	public List<Author> getAuthors() {
		List<Author> allAuthorList = (List<Author>) authorService.getAllAuthors();
		return allAuthorList;
	}

}
