package com.example.basicboard.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    private Integer age;

    private Member(String username, String password, Integer age) {
        this.username = username;
        this.password = password;
        this.age = age;
    }

    public static Member create(String username, String password, Integer age) {
        return new Member(username, password, age);
    }

    public void updatePassword(String password) {
        this.password = password;
    }
}
