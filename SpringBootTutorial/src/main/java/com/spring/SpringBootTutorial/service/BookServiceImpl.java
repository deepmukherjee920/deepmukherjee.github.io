package com.spring.SpringBootTutorial.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.spring.SpringBootTutorial.Entity.Book;
import com.spring.SpringBootTutorial.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public Book saveBook(Book book) {
		// TODO Auto-generated method stub
		return bookRepository.save(book);
	}

	@Override
	public List<Book> fetchBookList() {
		// TODO Auto-generated method stub
		return bookRepository.findAll();
	}

	@Override
	public Book fetchBookById(Integer bookId) {
		// TODO Auto-generated method stub
		return bookRepository.findById(bookId).get();
	}

	@Override
	public void deleteBookById(Integer bookId) {
		// TODO Auto-generated method stub
		bookRepository.deleteById(bookId);
	}

	@Override
	public Book updateBookById(Integer bookId, Book book) {
		// TODO Auto-generated method stub
		Book bk = bookRepository.findById(bookId).get();
		
		if(Objects.nonNull(book.getBookName()) && !"".equalsIgnoreCase(book.getBookName())) {
			bk.setBookName(book.getBookName());
		}
		
		if(Objects.nonNull(book.getAuthor()) && !"".equalsIgnoreCase(book.getAuthor())) {
			bk.setAuthor(book.getAuthor());
		}
		
		
		return bookRepository.save(bk);
	}

	@Override
	public Page<Book> getbookspage() {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(0, 5);
		 
		Page<Book> page = bookRepository.findAll(pageable);
		return page;
	}

	@Override
	public Page<Book> getbookspageBySorting() {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(0, 5, Sort.by("price").descending());
		 
		Page<Book> page = bookRepository.findAll(pageable);
		return page;
	}
	
	
	
	



}
