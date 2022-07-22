package com.recommendation.RecomendationApi.service;

import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.recommendation.RecomendationApi.dto.BookDTO;
import com.recommendation.RecomendationApi.exception.BookNotFoundException;
import com.recommendation.RecomendationApi.model.Book;
import com.recommendation.RecomendationApi.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	BookRepository bookRepository;

	@Override
	public List<Book> getAllBooks() {
		List<Book> books = bookRepository.findAll();
		return books;
	}

	@Override
	public Book addBook(Book book) {
		System.out.println("In Service");
		return bookRepository.save(book);
	}

	@Override
	public Book getBookById(int id) {

		return bookRepository.findBookByBookId(id);
	}

	@Override
	public Book getBookByName(String name) {
		return bookRepository.findBookByBookName(name);
	}

	@Override
	public void deleteBook(int id) {
		// TODO Auto-generated method stub
		Book book = bookRepository.findBookByBookId(id);
		if (book != null) {
			bookRepository.deleteById(id);
		} else {
			throw new BookNotFoundException("Book not found");
		}

	}

	@Override
	public Book UpdateBookById(int id, Book book) {
		Book bookForUpdate = bookRepository.findBookByBookId(id);
		if (bookForUpdate != null) {
			return bookRepository.save(book);
		} else {
			throw new BookNotFoundException("Book not found");
		}

	}
}

// private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
//public List<BookDTO> getAllBooks() {
//	logger.info("getAllBooks");
//	List<Book> bookList = bookRepository.findAll();
////	return bookList.stream().map(book -> new Book(book.getBookId(),book.getBookName(),book.getPrice(),book.getAuthor(),book.getBookName(),book.getRating()).collect(Collectors.toList()));
//	return null;
//	
//}

/*
 * public Book getBookById(int bookId) { Optional<Book> bookOptional =
 * bookRepository.findById(bookId); Book book = null; if
 * (bookOptional.isPresent()) { book =bookOptional.get();
 * logger.info(book.toString()); return book; } else { String errorMessage =
 * "Book with id " + bookId + " does not exist."; logger.error(errorMessage);
 * throw new BookNotFoundException(errorMessage); } }
 * 
 * public List<Book> getBookByName(String name) { logger.info(name);
 * 
 * @SuppressWarnings("unchecked") List<Book> bookList = (List<Book>)
 * bookRepository.FindBookByName(name); if (null != bookList) return bookList;
 * String errorMessage = "Book with Name " + name + " does not exist."; throw
 * new BookNotFoundException(errorMessage); }
 * 
 * 
 * public Book addBook(Book book) { logger.info(book.toString());
 * if(book.getAuthor()!= null)
 * 
 * AuthorService.getAuthorByBookName(book.getAuthor().toString());
 * 
 * return bookRepository.save(book); }
 * 
 * 
 * public Book updateBook(Book book) { logger.info(book.toString());
 * BookServiceImpl bookService = new BookServiceImpl();
 * bookService.getBookById(book.getBookId());
 * 
 * return bookRepository.save(book); }
 * 
 * public Book deleteBook(int id) { logger.info(Integer.toString(id)); Book
 * bookToDelete = this.getBookById(id); bookRepository.delete(bookToDelete);
 * return bookToDelete; }
 */