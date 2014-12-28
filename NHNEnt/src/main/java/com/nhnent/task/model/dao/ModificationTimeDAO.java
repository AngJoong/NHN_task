package com.nhnent.task.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import com.nhnent.task.model.dto.BoardDTO;
import com.nhnent.task.model.service.DBUtil;

@Component
public class ModificationTimeDAO {
	public boolean insertModificationTime(int boardNo) {
		SqlSession session = null;
		boolean flag = false;
		session = DBUtil.getSqlSession();
		flag = session.insert("modificationTime.insertModificationTime", boardNo) > 0? true : false;
		DBUtil.closeSqlSession(flag, session);		
		return flag;
	}
	
	public String selectModificationTime(int boardNo) {
		SqlSession session = null;
		String modificatinTime = null;
		session = DBUtil.getSqlSession();
		modificatinTime = session.selectOne("modificationTime.insertModificationTime", boardNo);
		DBUtil.closeSqlSession(session);		
		return modificatinTime;
	}
}

