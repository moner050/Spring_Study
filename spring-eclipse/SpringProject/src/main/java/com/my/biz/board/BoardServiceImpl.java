package com.my.biz.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// 4. Service 구현 클래스
@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired // Type Injection
	private BoardDAOSpring boardDAO;
	
	public BoardServiceImpl() {
		System.out.println("===> BoardServiceImpl 생성");
	}
	
//	public void setBoardDAO(BoardDAO boardDAO){
//		this.boardDAO = boardDAO;
//	}
	
	public void insertBoard(BoardVO vo) {
		if(vo.getSeq() == 0)
		{
			throw new IllegalArgumentException();
		}
		boardDAO.insertBoard(vo);
	}

	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}

	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}

	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}

	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("getBoardList 처리단계");
		return boardDAO.getBoardList(vo);
	}

}
