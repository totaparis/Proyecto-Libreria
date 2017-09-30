package com.libreria.component;

import org.springframework.stereotype.Component;

import com.libreria.entity.Book;
import com.libreria.model.BookModel;

@Component("bookConverter")
public class BookConverter {
	
	public Book convertBookModel2Book(BookModel bookModel){
		Book book = new Book();
		book.setIdBook(bookModel.getIdBook());
		book.setName(bookModel.getName());
		book.setIdCategory(bookModel.getIdCategory());
		book.setStatus(bookModel.getStatus());
		book.setDescription(bookModel.getDescription());
		book.setActive(bookModel.getActive());
		return book;
	}
	
	public BookModel convertBook2BookModel(Book book){
		BookModel bookModel = new BookModel();
		bookModel.setIdBook(book.getIdBook());
		bookModel.setName(book.getName());
		bookModel.setIdCategory(book.getIdCategory());
		bookModel.setStatus(book.getStatus());
		bookModel.setDescription(book.getDescription());
		bookModel.setActive(book.getActive());
		
		return bookModel;
	}
}
