package com.example.crudboard.controller;

import com.example.crudboard.entity.Post;
import com.example.crudboard.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public String listPosts(Model model) {
        model.addAttribute("posts", postService.getAllPosts());
        return "post/list";
    }

    @GetMapping("/{id}")
    public String viewPost(@PathVariable Long id, Model model) {
        Optional<Post> optionalPost = postService.getPostById(id);

        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            model.addAttribute("post", post);
            return "post/detail";
        } else {
            return "redirect:/posts";
        }
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "post/create";
    }


    // 새 글 저장
    @PostMapping
    public String createPost(Post post) {
        postService.createPost(post);
        return "redirect:/posts"; // 저장 후 목록으로 리다이렉트
    }

}
