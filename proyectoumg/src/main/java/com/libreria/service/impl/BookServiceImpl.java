package com.libreria.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.libreria.component.BookConverter;
import com.libreria.entity.Book;
import com.libreria.model.BookModel;
import com.libreria.repository.BookRepository;
import com.libreria.service.BookService;

@Service("bookServiceImpl")
public class BookServiceImpl implements BookService {
	
	private static final Log LOG = LogFactory.getLog(BookServiceImpl.class);
	
	@Autowired
	@Qualifier("bookRepository")
	private BookRepository bookRepository;

	@Autowired
	@Qualifier("bookConverter")
	private BookConverter bookConverter;
	
	@Override
	public BookModel addBook(BookModel bookModel) {
		Book book = bookRepository.save(bookConverter.convertBookModel2Book(bookModel));
		
		return bookConverter.convertBook2BookModel(book);
	}
	
	@Override
	public List<BookModel> listAllBooks() {
		LOG.info("Call: " + " SERVICE IMPLEMENT - listAllBooks()");
		List<Book> books = bookRepository.findAll();		
		List<BookModel> booksModel = new ArrayList<BookModel>();
		for (Book book: books ){
			booksModel.add(bookConverter.convertBook2BookModel(book));
			
		}
		return booksModel;
	}

	@Override
	public Book findBookByidBook(int id) {
		return bookRepository.findByidbook(id);
	}
	
	public BookModel findBookByidBookModel(int id){		
		return bookConverter.convertBook2BookModel(findBookByidBook(id));
	} 

	@Override
	public void removeBook(int id) {
		Book book = bookRepository.findByidbook(id);
		if(null != book){
			bookRepository.delete(book);	}
		
	}
	
}
