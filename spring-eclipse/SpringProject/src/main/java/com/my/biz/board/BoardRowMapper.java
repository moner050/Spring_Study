package com.my.biz.board;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BoardRowMapper implements RowMapper<BoardVO> {

	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		// 매개변수로 받은 ResultSet의 ROW를 어떤 자바객체(VO)에 매핑할 것인지를 기술한다.
		// System.out.println(rowNum + " 번째 ROW 정보를 BoardVO 객체에 매핑한다.");
		BoardVO board = new BoardVO();
		board.setSeq(rs.getInt("SEQ"));
		board.setTitle(rs.getString("TITLE"));
		board.setContent(rs.getString("CONTENT"));
		board.setWriter(rs.getString("WRITER"));
		board.setRegDate(rs.getDate("REGDATE"));
		board.setCnt(rs.getInt("CNT"));
		return board;
	}

}
