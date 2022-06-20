package lmh.boardspring.board.service;

import java.util.List;
import lmh.boardspring.board.domain.Board;
import lmh.boardspring.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class BoardService {

    // 생성자 주입방법
    private final BoardRepository boardRepository;

    // 외부에서 BoardRepository 를 넣어줌.(DI)
    @Autowired
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    // 게시글 전체 조회
    public List<Board> boardList(){
        return boardRepository.getBoardList();
    }

}
