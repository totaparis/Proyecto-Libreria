package com.libreria.component;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


import com.libreria.repository.BookRepository;

@Component("bookComponent")
public class BookComponent {
	
	private static final Log LOG = LogFactory.getLog(BookComponent.class);
	
	@Autowired
	@Qualifier("bookRepository")
	private BookRepository bookRepository;
	
	public void sayHello(){
		LOG.info("Hello From Example Component");
	}
}
