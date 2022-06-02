package com.my.biz.board;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {

	public static void main(String[] args) {

		// 1. 스프링 컨테이너 생성
		GenericXmlApplicationContext container = new GenericXmlApplicationContext("business-layer.xml");
		
		// 2. 테스트 객체 Lookup
		BoardService boardService = (BoardService) container.getBean("boardService");
		if(boardService != null) System.out.println("Lookup 성공 : " + boardService.toString());
		
		// 3. Lookup 한 객체의 메소드 테스트
		BoardVO vo = new BoardVO();
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		List<BoardVO> boardList = boardService.getBoardList(vo);
		
		for(BoardVO board : boardList)
		{
			System.out.println("--->" + board.getTitle());
		}
		
		// 4. 컨테이너 종료
		container.close();
		
	}

}
