package lmh.boardspring.config;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import lmh.boardspring.board.repository.BoardRepository;
import lmh.boardspring.board.repository.JpaBoardRepository;
import lmh.boardspring.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

//    private final BoardRepository boardRepository;
//
//    @Autowired
//    public SpringConfig(BoardRepository boardRepository) {
//        this.boardRepository = boardRepository;
//    }
//
//    @Bean
//    public BoardService boardService(){
//        return new BoardService(boardRepository);
//    }

    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em){
        this.em = em;
    }

    @Bean
    public BoardService boardService(){
        return new BoardService(boardRepository());
    }

    @Bean
    public BoardRepository boardRepository(){
        return new JpaBoardRepository(em);
    }
}
