package lmh.boardspring.board.controller;

import java.util.List;
import lmh.boardspring.board.domain.Board;
import lmh.boardspring.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/board")
    public String list(Model model){
        List<Board> board = boardService.boardList();
        model.addAttribute("board", board);
        return "board/boardList";
    }
}
