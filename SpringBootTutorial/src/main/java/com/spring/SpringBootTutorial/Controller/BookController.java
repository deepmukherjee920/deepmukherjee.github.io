package com.spring.SpringBootTutorial.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.SpringBootTutorial.Entity.Book;
import com.spring.SpringBootTutorial.service.BookService;
//import com.spring.SpringBootTutorial.service.BookServiceImpl;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@PostMapping("/books")
	public Book saveBook(@Valid @RequestBody Book book) {
		return bookService.saveBook(book);
	}
	
	@GetMapping("/books")
	public List<Book> fetchBookList(){
		return bookService.fetchBookList();
	}
	
	@GetMapping("/books/{id}")
	public Book fetchBookById(@PathVariable("id") Integer bookId){
		return bookService.fetchBookById(bookId);
	}
	
	@DeleteMapping("/books/{id}")
	public String deleteBookById(@PathVariable("id") Integer bookId) {
		bookService.deleteBookById(bookId);
		return "Book Deleted Successfully";
		
	}
	
	@PutMapping("/books/{id}")
	public Book updateBook(@PathVariable("id") Integer bookId, @RequestBody Book book) {
		return bookService.updateBookById(bookId, book);
	}
	
	@GetMapping("/bookspage")
	public List<Book> getbookspage(){
		Page<Book> getBookPage = bookService.getbookspage();
		List <Book> listBook = getBookPage.getContent();
		return listBook;

	}
	
	@GetMapping("/bookspageBySort")
	public List<Book> getbookspageBySorting(){
		Page<Book> getBookPage = bookService.getbookspageBySorting();
		List <Book> listBook = getBookPage.getContent();
		return listBook;
		
	}
	
	
	
}
