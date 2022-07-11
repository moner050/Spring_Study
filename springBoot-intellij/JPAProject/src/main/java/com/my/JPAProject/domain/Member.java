package com.my.JPAProject.domain;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    private int id;

    private String name;

    private String city;

    // 양방향 매핑
    // Member 와 관련된 Order 목록을 꺼내서 삭제를 해준다.
    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Order> orderList = new ArrayList<Order>();

}
