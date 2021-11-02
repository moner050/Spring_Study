package domain;


import domain.converter.BookStatusConverter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Where(clause = "deleted = false")
public class Book extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(100) comment '이름'", nullable = false)
    private String name;
    private String category;
    private Long authorId;
    private Boolean deleted;

    @OneToMany
    @JoinColumn(name = "book_id")
    @ToString.Exclude
    private List<Review> reviewList = new ArrayList<>();

    @OneToOne(mappedBy = "book")
    private BookReview bookReview;

    @Convert(converter = BookStatusConverter.class)

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @ToString.Exclude
    private Publisher publisher;

    @Override
    public String toString()
    {
        return "Book{" +
                "id=" + id +
                ", name=" + name + '\'' +
                ", category=" + category + '\'' +
                ", authorId=" + authorId +
                ", deleted=" + deleted +
                ", status=" + status +
                "}";
    }
}
