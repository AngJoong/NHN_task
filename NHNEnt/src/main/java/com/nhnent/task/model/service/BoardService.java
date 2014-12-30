package com.nhnent.task.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nhnent.task.model.dao.BoardDAO;
import com.nhnent.task.model.dao.ModificationTimeDAO;
import com.nhnent.task.model.dto.BoardDTO;

@Component
public class BoardService {

	@Autowired
	private BoardDAO boardDAO;

	@Autowired
	private ModificationTimeDAO modificationTime;
	

/*
  	public String selectModificationTime(int boardNo) {
		return modificationTime.selectModificationTime(boardNo);
	}
		
*/
	public void insertModificationTime(int boardNo) {
		modificationTime.insertModificationTime(boardNo);
//		if(!modificationTime.insertModificationTime(boardNo)){
//			throw new Exception();
//		}
	}
			
	
	public void insertBoard(BoardDTO board) {
		boardDAO.insertBoard(board);
	}
	
	public void updateBoard(BoardDTO board){
		boardDAO.updateBoard(board);
	}
	
	public BoardDTO selectBoardByBoardNo(int boardNo){
		return boardDAO.selectBoardByBoardNo(boardNo);
	}
	
	public List<BoardDTO> selectAllBoard(){
		return boardDAO.selectAllBoard();
	}
	
	public BoardDTO selectBoardByBoardNoAndPassWord(BoardDTO boardData){
		return boardDAO.selectBoardByBoardNoAndPassWord(boardData);
	}
		
}
