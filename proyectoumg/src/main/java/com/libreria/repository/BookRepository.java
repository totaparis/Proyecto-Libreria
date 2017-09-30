package com.libreria.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.libreria.entity.Book;

@Repository("bookRepository")
public interface BookRepository extends JpaRepository<Book, Serializable> {
	
	public abstract Book findByidbook(int idbook);
	
	
}
