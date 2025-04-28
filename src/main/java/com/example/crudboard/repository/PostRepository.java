package com.example.crudboard.repository;

import com.example.crudboard.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    // JpaRepository를 상속하면 기본적인 CRUD 메서드를 사용할 수 있습니다.
    // save(), findAll(), findById()와 같은 메서드
}
