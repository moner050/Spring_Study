package com.my.biz.board;

import java.util.List;

public class BoardDAOClient {

	public static void main(String[] args) throws Exception{

		BoardVO vo = new BoardVO();
		vo.setTitle("");
		vo.setWriter("");
		vo.setContent("");
		
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.insertBoard(vo);
		
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		for(BoardVO board : boardList) {
			System.out.println("--->" + board.toString());
		}
	}

}
