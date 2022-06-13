package com.my.biz.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

// 2. DAO(Data Access Object) 클래스
//@Repository
public class BoardDAOSpring implements BoardDAO{

	@Autowired
	private JdbcTemplate spring;
	
	// SQL 명령어
	private final String BOARD_INSERT = "insert into board(seq, title, writer, content) "
//			                          + "values((select nvl(max(seq), 0) + 1 from board), ?, ?, ?)";
            						  + "values(?, ?, ?, ?)";
	private final String BOARD_UPDATE = "update board set title = ?, content = ? where seq = ?";
	private final String BOARD_DELETE = "delete board where seq = ?";
	private final String BOARD_LIST_T = "select * from board where title   like '%'||?||'%' order by seq desc";
	private final String BOARD_LIST_C = "select * from board where content like '%'||?||'%' order by seq desc";
	private final String BOARD_GET    = "select * from board where seq = ?";

	// CRUD 기능의 메소드
	// 글 등록
	public void insertBoard(BoardVO vo) {
		System.out.println("===> Spring 기반으로 insertBoard() 기능 처리");
		spring.update(BOARD_INSERT,vo.getSeq(), vo.getTitle(), vo.getWriter(), vo.getContent());
	}
	
	// 글 수정
	public void updateBoard(BoardVO vo) {
		System.out.println("===> Spring 기반으로 updateBoard() 기능 처리");
		spring.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
	}
	
	// 글 삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> Spring 기반으로 deleteBoard() 기능 처리");
		spring.update(BOARD_DELETE, vo.getSeq());
	}
	
	// 글 상세 조회
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> Spring 기반으로 getBoard() 기능 처리");
		return spring.queryForObject(BOARD_GET, new BoardRowMapper(), vo.getSeq());
	}
	
	// 글 목록 검색
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> Spring 기반으로 InsertBoard() 기능 처리");
		if(vo.getSearchCondition().equals("TITLE")) {
			return spring.query(BOARD_LIST_T, new BoardRowMapper(), vo.getSearchKeyword());
		} 
		else if(vo.getSearchCondition().equals("CONTENT")) {
			return spring.query(BOARD_LIST_C, new BoardRowMapper(), vo.getSearchKeyword());
		}
		return null;
	}
}
