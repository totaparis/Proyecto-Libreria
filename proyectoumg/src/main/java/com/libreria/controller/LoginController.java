package com.libreria.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.libreria.constant.ViewConstant;
import com.libreria.model.EmployeeModel;

@Controller
public class LoginController {
	
	private static final Log LOG = LogFactory.getLog(LoginController.class);
	
	@GetMapping("/")
	public String redirectToLogin(){
		LOG.info("METHOD: redirectToLogin()");
		return "redirect:/login";
		
	}
	
	@GetMapping("/login")
	public String showLoginForm(Model model,
			@RequestParam(name="error",required=false) String error,
			@RequestParam(name="logout",required=false) String logout){
		LOG.info("METHOD: showLoginForm() -- PARAMS: error=" + error +", logout="+ logout);
		model.addAttribute("error",error);
		model.addAttribute("logout",logout);
		model.addAttribute("employee", new EmployeeModel());
		LOG.info("Returning to login view");
		return ViewConstant.LOGIN;		
	}
	@PostMapping("/logincheck")
	public String loginCheck(@ModelAttribute(name="employee") EmployeeModel employee){
		String value="";
		
		LOG.info("METHOD: showLoginForm() -- PARAMS: " +employee.toString());
		if(employee.getUsername().equals("user") && employee.getPassword().equals("user")){
			LOG.info("Returning to books view");
			value = "redirect:/books/showbooks" ;
		}else{
			LOG.info("Returning to login?error");
			value = "redirect:/login?error";
		}		
		return value;		
	}
}
