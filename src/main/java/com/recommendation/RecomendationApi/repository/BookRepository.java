package com.recommendation.RecomendationApi.repository;

//import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recommendation.RecomendationApi.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer>
{
	
	public Book findBookByBookId(int id);

	public Book findBookByBookName(String name);
	
}
