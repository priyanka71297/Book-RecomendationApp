package com.recommendation.RecomendationApi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.recommendation.RecomendationApi.dto.BookDTO;
import com.recommendation.RecomendationApi.model.Book;
import com.recommendation.RecomendationApi.service.BookService;

@RestController
@RequestMapping("/user")
public class BookController {

	@Autowired
	BookService bookservice;

	@GetMapping("/get-all-books")
	public List<Book> getBooks() {
		List<Book> allBookList = (List<Book>) bookservice.getAllBooks();
		return allBookList;
	}

	@GetMapping("/get-book-by-id/{id}")
	public ResponseEntity<Book> getBookByid(@PathVariable("id") int id) {
		Book book = bookservice.getBookById(id);
		if (book == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));
	}
	
	@GetMapping("/get-book-by-name/{name}")
	public ResponseEntity<Book> getBookByName(@PathVariable("name") String name) {
		Book book = bookservice.getBookByName(name);
		if (book == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));
	}
	

	/*
	 * 
	 * @PostMapping("/books") public ResponseEntity<Book> addBook(@RequestBody Book
	 * book) { Book b = bookservice.addBook(book); if(b!=null) { return
	 * ResponseEntity.status(HttpStatus.OK).build(); } System.out.println(b); return
	 * ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build(); }
	 * 
	 * 
	 * @DeleteMapping("/books/{id}") public ResponseEntity<Book>
	 * deleteBook(@PathVariable("id") int id) { try { bookservice.deleteBook(id);
	 * return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); }catch(Exception
	 * e) { e.printStackTrace(); return
	 * ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); } }
	 * 
	 * @PutMapping("/books/{id}") public ResponseEntity<Book>
	 * updateBook(@RequestBody Book book,@PathVariable("id") int id) {
	 * 
	 * Book b=bookservice.updateBook(book); if(b!=null) { return
	 * ResponseEntity.status(HttpStatus.OK).body(book); } return
	 * ResponseEntity.status(HttpStatus.NON_AUTHORITATIVE_INFORMATION).build(); }
	 */

}
