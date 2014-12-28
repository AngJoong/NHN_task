package com.nhnent.task.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import com.nhnent.task.model.dto.BoardDTO;
import com.nhnent.task.model.service.DBUtil;

@Component
public class BoardDAO {
	public boolean insertBoard(BoardDTO board) {
		SqlSession session = null;
		boolean flag = false;
		session = DBUtil.getSqlSession();
		flag = session.insert("board.insertBoard", board) > 0? true : false;
		DBUtil.closeSqlSession(flag, session);		
		return flag;
	}
	
	public boolean updateBoard(BoardDTO board){
		SqlSession session = null;
		boolean flag = false;
		session = DBUtil.getSqlSession();
		flag = session.update("board.updateBoard", board) > 0? true : false;
		DBUtil.closeSqlSession(flag, session);
		return flag;
	}
	
	public BoardDTO selectBoardByBoardNo(int boardNo){
		SqlSession session = null;
		BoardDTO board = null;		
		session = DBUtil.getSqlSession();
		board = session.selectOne("board.selectBoardByBoardNo", boardNo);
		DBUtil.closeSqlSession(session);		
		return board;
	}
	
	public List<BoardDTO> selectAllBoard(){
		SqlSession session = null;
		List<BoardDTO> boardList = null;
		session = DBUtil.getSqlSession();
		boardList = session.selectList("board.selectAllBoard");
		DBUtil.closeSqlSession(session);		
		return boardList;
	}
	
	public BoardDTO selectBoardByBoardNoAndPassWord(BoardDTO boardData){
		SqlSession session = null;
		BoardDTO board = null;
		session = DBUtil.getSqlSession();
		board = session.selectOne("board.selectBoardByBoardNoAndPassWord", boardData);
		DBUtil.closeSqlSession(session);		
		return board;
	}
}
