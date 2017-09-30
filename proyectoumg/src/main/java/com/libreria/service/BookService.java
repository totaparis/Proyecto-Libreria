package com.libreria.service;

import java.util.List;

import com.libreria.entity.Book;
import com.libreria.model.BookModel;



public interface BookService {
	
	public abstract BookModel addBook(BookModel bookModel);
	
	public abstract List<BookModel> listAllBooks();
	
	public abstract Book findBookByidBook(int id);
	
	public abstract void removeBook(int id);
	
	public abstract BookModel findBookByidBookModel(int id);
	
}
