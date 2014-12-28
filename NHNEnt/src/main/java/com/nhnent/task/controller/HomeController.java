package com.nhnent.task.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nhnent.task.model.dto.BoardDTO;
import com.nhnent.task.model.service.BoardService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private BoardService boardService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "board";
	}

	@RequestMapping(value = "/insertBoard", method = RequestMethod.POST)
	public String insertBoard(@RequestParam("email") String email, @RequestParam("password") String password, 
			/*@RequestParam("attachment") String attachment,*/ @RequestParam("body") String body) {
		
			String regex = "\\w+@\\w+.\\w+";
			BoardDTO newBoard = null;
			Pattern pattern = null;
			Matcher matcher = null;			
			
			if(email == null ||email.trim() == "" 
				|| password == null || password.trim() == ""
				|| body == null || body.trim() == ""){
				return "board";
			}
			
			pattern = Pattern.compile(regex);
			matcher = pattern.matcher(email);
			matcher.matches();
			
			if(!matcher.matches()){
				return "board";
			}
			
			newBoard = new BoardDTO(email, password, body);
			
			boardService.insertBoard(newBoard);
		
		return "board";
	}
	
	
	
}
