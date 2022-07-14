package com.my.toyproject.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;


@Data
@Table(name = "USERS")
@Entity
public class User {

    // 식별자 변수(Primary key) 선언
    @Id
    // 1부터 시작하여 자동으로 1씩 값이 증가하도록 설정한다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 50, unique = true)
    private String username; // 아이디

    @Column(length = 50)
    private String password; // 비밀번호

    @Column(nullable = false, length = 100)
    private String email; // 이메일

    private String role;

    @CreationTimestamp // 현재 시간 정보가 자동으로 설정된다.
    private Timestamp createDate;
}
