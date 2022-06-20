package lmh.boardspring.board.controller;

import java.sql.Date;
import lombok.Data;

@Data
public class BoardForm {

    private Integer seq;
    private String title;
    private String writer;
    private Date regdate;
    private int cnt;


}
