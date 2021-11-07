package com.spring.jpa.test.JpaTest.domain;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@RequiredArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Publisher extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String name;


    @OneToMany(orphanRemoval = true, cascade = {CascadeType.ALL})
    @JoinColumn(name = "publisher_id")
    @ToString.Exclude
    private List<Book> bookList = new ArrayList<>();

    public void addBook(Book book)
    {
        this.bookList.add(book);
    }
}
