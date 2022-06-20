package com.my.biz.board;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.my.biz.util.SqlMapClientFactoryBean;

public class BoardDAO {
	
	// SqlMapClient가 바로 iBATIS 컨테이너다.
	private SqlMapClient ibatis;
	
	public BoardDAO() {
		ibatis = SqlMapClientFactoryBean.getSqlMapClientInstance();
	}
	
	public void insertBoard(BoardVO vo) throws SQLException {
		ibatis.insert("insertBoard", vo);
	}
	
	public void updateBoard(BoardVO vo) throws SQLException {
		ibatis.update("updateBoard", vo);
	}
	
	public void deleteBoard(BoardVO vo) throws SQLException {
		ibatis.delete("deleteBoard", vo);
	}
	
	public BoardVO getBoard(BoardVO vo) throws SQLException {
		return (BoardVO) ibatis.queryForObject("getBoard", vo);
	}
	
	public List<BoardVO> getBoardList(BoardVO vo) throws SQLException {
		return ibatis.queryForList("getBoardList");
	}
}
