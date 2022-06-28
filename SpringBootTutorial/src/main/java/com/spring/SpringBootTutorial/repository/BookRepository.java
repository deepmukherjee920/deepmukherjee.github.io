package com.spring.SpringBootTutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.SpringBootTutorial.Entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
	
	
}
