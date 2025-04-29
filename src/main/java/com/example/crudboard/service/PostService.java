package com.example.crudboard.service;

import com.example.crudboard.entity.Post;
import com.example.crudboard.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // 게시글 생성
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    // 게시글 조회 (ID로)
    public Optional<Post> getPostById(Long id) {
        return postRepository.findById(id);
    }

    // 게시글 수정
    public Post updatePost(Long id, Post post) {
        if (postRepository.existsById(id)) {
            post.setId(id);
            return postRepository.save(post);
        }
        throw new RuntimeException("Post not found");
    }

    // 게시글 삭제
    public void deletePost(Long id) {
        if (postRepository.existsById(id)) {
            postRepository.deleteById(id);
        } else {
            throw new RuntimeException("Post not found");
        }
    }

    // 모든 게시글 목록 조회
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }
}
