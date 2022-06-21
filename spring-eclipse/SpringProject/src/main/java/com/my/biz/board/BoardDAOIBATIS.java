package com.my.biz.board;

import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

public class BoardDAOIBATIS {
	
	// SqlMapClient가 바로 iBATIS 컨테이너다.
	private SqlMapClientTemplate ibatis;
	
	// 글 추가
	public void insertBoard(BoardVO vo) throws SQLException {
		ibatis.insert("insertBoard", vo);
	}
	
	// 글 수정
	public void updateBoard(BoardVO vo) throws SQLException {
		ibatis.update("updateBoard", vo);
	}
	
	// 글 삭제
	public void deleteBoard(BoardVO vo) throws SQLException {
		ibatis.delete("deleteBoard", vo);
	}
	
	// 글 상세 조회
	public BoardVO getBoard(BoardVO vo) throws SQLException {
		return (BoardVO) ibatis.queryForObject("getBoard", vo);
	}
	
	// 글 목록 검색
	public List<BoardVO> getBoardList(BoardVO vo) throws SQLException {
		return ibatis.queryForList("getBoardList", vo);
	}
}
