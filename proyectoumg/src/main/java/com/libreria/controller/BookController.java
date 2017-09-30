package com.libreria.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.libreria.constant.ViewConstant;
import com.libreria.model.BookModel;
import com.libreria.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {

	
	private static final Log LOG = LogFactory.getLog(BookController.class);
	
	@Autowired	
	@Qualifier("bookServiceImpl")
	private BookService bookService;
	
	@GetMapping("/cancel")
	private String cancel(){		
		return ViewConstant.BOOKS;		
	}
	
	@GetMapping("/bookform")
	private String redirectBookForm(@RequestParam(name="id", required=false)int id,
			Model model){
		BookModel book = new BookModel();
		if(id != 0){
			book = bookService.findBookByidBookModel(id);
		}		
		model.addAttribute("bookModel", book);
		LOG.info("call:" + "BookForm");
		return ViewConstant.BOOK_FORM;		
	}
	
	@GetMapping("/showbooks")
	public ModelAndView showBooks(){
		LOG.info("call:" + "showBooks()");
		ModelAndView mav = new ModelAndView(ViewConstant.BOOKS);		
		mav.addObject("books", bookService.listAllBooks());
		LOG.info(mav);
		return mav;
	}
	
	@PostMapping("/addbook")
	public String addBook(@ModelAttribute(name="bookModel") BookModel bookModel,
			Model model){
		LOG.info("METHOD: "+"addBook()"+ "--- PARAMS: " + bookModel.toString());
		
		if(null != bookService.addBook(bookModel)){
			model.addAttribute("result", 1);
		}else{
			model.addAttribute("result", 0);
		}
		
		return "redirect:/books/showbooks";
	}
	
	@GetMapping("/removebook")
	public ModelAndView removeBook(@RequestParam(name="id", required=true)int id){
		bookService.removeBook(id);		
		return showBooks();
		
	}
	
	@GetMapping("/findbook")
	public ModelAndView findBook(@RequestParam(name="id", required=false, defaultValue="15")int id){
		ModelAndView mav = new ModelAndView(ViewConstant.FINDBOOK);
		
		if( null != bookService.findBookByidBookModel(id)){			
			mav.addObject("books", bookService.findBookByidBookModel(id));	
			LOG.info(mav);
		}else{
			mav.addObject("books", bookService.listAllBooks());
				
			
		}	
		LOG.info(mav);
		return mav;
	}
	
	

}
