package com.spring.SpringBootTutorial.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.spring.SpringBootTutorial.Entity.Book;

public interface BookService {

	public Book saveBook(Book book);

	public List<Book> fetchBookList();

	public Book fetchBookById(Integer bookId);

	public void deleteBookById(Integer bookId);

	public Book updateBookById(Integer bookId, Book book);
	
	public Page<Book> getbookspage();
	
	public Page<Book> getbookspageBySorting();
}
