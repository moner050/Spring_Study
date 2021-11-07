package com.spring.jpa.test.JpaTest.domain;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Review extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private float score;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Book book;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id")
    private List<Comment> comments;

    @Override
    public String toString()
    {
        return "review{" +
                "id=" + id +
                ", title=" + title + '\'' +
                ", content=" + content + '\'' +
                ", score=" + score +
                "}";
    }

}
