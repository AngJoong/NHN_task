package com.nhnent.task.controller;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nhnent.task.model.dto.BoardDTO;
import com.nhnent.task.model.service.BoardService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private BoardService boardService;
		
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		List<BoardDTO> BoardList = null;
		
		BoardList = boardService.selectAllBoard();
		model.addAttribute("boardList", BoardList);
		
		return "board";
	}

	@RequestMapping(value = "/insertBoard", method = RequestMethod.POST)
	public String insertBoard(@RequestParam("email") String email, @RequestParam("password") String password, 
			/*@RequestParam("attachment") String attachment,*/ @RequestParam("body") String body, Model model) {
		
			System.out.println(body);
		
			String regex = "\\w+@\\w+.\\w+";
			BoardDTO newBoard = null;
			Pattern pattern = null;
			Matcher matcher = null;		
			List<BoardDTO> BoardList = null;
			
/*
 			if(email == null ||email.trim() == "" 
				|| password == null || password.trim() == ""
				|| body == null || body.trim() == ""){
				return "board";
			}
*/
			
			pattern = Pattern.compile(regex);
			matcher = pattern.matcher(email);
			matcher.matches();
			
			if(!matcher.matches()){
				return "board";
			}
			
			newBoard = new BoardDTO(email, password, null, body);
			boardService.insertBoard(newBoard);
			
			BoardList = boardService.selectAllBoard();
			model.addAttribute("boardList", BoardList);
		
		return "board";
	}
	
	@RequestMapping(value = "/updateBoard", method = RequestMethod.POST)
	public String updateBoard(@RequestParam("boardno") int boardNo,
			/*@RequestParam("attachment") String attachment,*/ @RequestParam("body") String body, Model model) {
		
			System.out.println(boardNo);
			BoardDTO newBoard = null;
			List<BoardDTO> BoardList = null;
			
			newBoard = new BoardDTO(boardNo, body, null);
			boardService.updateBoard(newBoard);
						
			BoardList = boardService.selectAllBoard();
			model.addAttribute("boardList", BoardList);
		
		return "board";
	}

	@RequestMapping(value = "/checkPassword", method = RequestMethod.GET)
	@ResponseBody
	public String checkPassword(@RequestParam("boardNo") int boardNo, 
			@RequestParam("password") String password, Model model) {

			if(boardService.selectBoardByBoardNoAndPassWord(new BoardDTO(boardNo, password)) == null){
				return "false";
			}else{
				return "true";
			}
	}
	
}
