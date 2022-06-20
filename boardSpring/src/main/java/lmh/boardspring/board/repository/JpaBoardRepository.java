package lmh.boardspring.board.repository;

import java.util.List;
import javax.persistence.EntityManager;
import lmh.boardspring.board.domain.Board;

public class JpaBoardRepository implements BoardRepository{

    private final EntityManager em;

    public JpaBoardRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Board> getBoardList() {
        return em.createQuery("select b from Board b", Board.class)
            .getResultList();
    }

}
