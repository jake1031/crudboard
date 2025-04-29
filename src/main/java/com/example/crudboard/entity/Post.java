package com.example.crudboard.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter  // 자동으로 모든 필드에 대한 getter 메서드 생성
@Setter  // 자동으로 모든 필드에 대한 setter 메서드 생성
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 500)
    private String content;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    // 기본 생성자
    public Post() {}

    // 생성자 (title, content)
    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
