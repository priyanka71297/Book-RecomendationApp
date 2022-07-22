package com.recommendation.RecomendationApi.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.recommendation.RecomendationApi.model.Author;
import com.recommendation.RecomendationApi.model.Book;

@Service
public interface AuthorService {

	Author getAuthorById(int authorid);

	List<Author> getAllAuthors();

	Author addAuthor(Author author);

}
