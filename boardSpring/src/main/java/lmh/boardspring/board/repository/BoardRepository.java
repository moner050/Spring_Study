package lmh.boardspring.board.repository;

import java.util.List;
import lmh.boardspring.board.domain.Board;

public interface BoardRepository{

    // 게시글 전체 리스트 출력
    List<Board> getBoardList();

    // 게시글 상세보기
//    Board getBoard(Integer seq);
    // 게시글 등록
//    Board insertBoard(Integer seq, String title, String writer, String content);
    // 게시글 수정
//    Board updateBoard(Integer seq, String title, String content);
    // 게시글 삭제
//    Board deleteBoard(String seq);

    // 게시글 검색(제목)
//    Board searchBoardTitle(String title);
    // 게시글 검색(내용)
//    Board searchBoardContent(String content);




}
