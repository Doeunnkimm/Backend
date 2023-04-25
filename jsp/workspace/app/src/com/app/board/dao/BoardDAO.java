package com.app.board.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.app.board.domain.BoardDTO;
import com.app.board.domain.Search;
import com.app.mybatis.config.MyBatisConfig;

public class BoardDAO {
public SqlSession sqlSession;
	
	public BoardDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
//	게시글 전체 조회
	public List<BoardDTO> selectAll(HashMap<String, Object> pagable){
		return sqlSession.selectList("board.selectAll", pagable);
	}
	
//	전체 게시글 개수 조회
	public int getTotal(Search search) {
		return sqlSession.selectOne("board.getTotal", search);
	}
	
}




















