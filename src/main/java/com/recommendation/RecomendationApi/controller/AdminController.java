package com.recommendation.RecomendationApi.controller;

//import java.awt.PageAttributes.MediaType;
import java.util.HashMap;
import java.util.List;
//import java.util.List;
import java.util.Map;
import java.util.Optional;

//import javax.security.auth.message.config.AuthConfig;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.recommendation.RecomendationApi.model.Author;
import com.recommendation.RecomendationApi.model.Book;
import com.recommendation.RecomendationApi.model.Category;
import com.recommendation.RecomendationApi.service.AuthorService;
import com.recommendation.RecomendationApi.service.AuthorServiceImpl;
import com.recommendation.RecomendationApi.service.BookService;
import com.recommendation.RecomendationApi.service.CategoryService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class AdminController {

	// Use ResponseEntity to all the methods in controller classes.

	@Autowired
	private BookService bookService;

	@Autowired(required=false)
	private AuthorService authorService;

	@Autowired
	private CategoryService categoryService;

	// private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/get-all-books")
	public List<Book> getBooks() {
		List<Book> allBookList = (List<Book>) bookService.getAllBooks();
		return allBookList;
	}

	@GetMapping("/get-book-by-id/{id}")
	public ResponseEntity<Book> getBookByid(@PathVariable("id") int id) {
		Book book = bookService.getBookById(id);
		if (book == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));
	}
	
	@GetMapping("/get-book-by-name/{name}")
	public ResponseEntity<Book> getBookByName(@PathVariable("name") String name) {
		Book book = bookService.getBookByName(name);
		if (book == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));
	}

//	@SuppressWarnings("null")
	@PostMapping(value = "/add-book")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {

		Book b = bookService.addBook(book);
		if (b != null) {
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
	}

	@PutMapping("/updateBookById/{id}")
	public Book updateBookById(@PathVariable("id") int id, @RequestBody Book book) {

		Book b = bookService.getBookById(id);

		if (book.getBookName() != null || book.getBookName().trim().length() > 0) {
			b.setBookName(book.getBookName());
		}

		if (book.getPrice() > 0.0) {
			b.setPrice(book.getPrice());
		}

		if (book.getRating() > 0.0) {
			b.setRating(book.getRating());
		}

		if (book.getCategory() != null) {
			Category c = new Category();
			c.setCategoryId(book.getCategory().getCategoryId());
			c.setCategory(book.getCategory().getCategory());
			b.setCategory(book.getCategory());
		}

		if (book.getAuthor() != null) {
			Author a = new Author();
			a.setAuthorid(book.getAuthor().getAuthorid());
			a.setAuthorName(book.getAuthor().getAuthorName());
			b.setAuthor(book.getAuthor());
		}

		Book updatedBook = bookService.UpdateBookById(id, b);

		return updatedBook;
	}

	// @SuppressWarnings("null")
	@DeleteMapping("/deleteBookById/{id}")
	public Map<String, Boolean> deleteBookById(@PathVariable("id") int id) {

		bookService.deleteBook(id);

		Map<String, Boolean> res = new HashMap<String, Boolean>();
		res.put("Deleted", true);
		return res;
	}

//	@SuppressWarnings("null")
	@PostMapping(value = "/addAuthor")
	public ResponseEntity<Author> addAuthor(@RequestBody Author author) {

		Author a = authorService.addAuthor(author);
		if (a != null) {
			return ResponseEntity.status(HttpStatus.OK).build();
		} else {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
		}
	}

	// @SuppressWarnings("null")
	@PostMapping(value = "/addCategory")
	public ResponseEntity<Category> addCategory(@RequestBody Category category) {

		Category c = categoryService.addCategory(category);
		if (c != null) {
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
	}

}
