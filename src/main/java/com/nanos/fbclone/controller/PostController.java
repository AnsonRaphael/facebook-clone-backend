package com.nanos.fbclone.controller;

import com.nanos.fbclone.model.Post;
import com.nanos.fbclone.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@CrossOrigin(value = "http://localhost:3000/")
@RestController
@RequestMapping("/api/v1/post")
@AllArgsConstructor
public class PostController {

    private PostService postService;
    @PostMapping
    public Post addPost(@RequestParam Map<String,String> stringMap) throws Exception {
        String reqPost=stringMap.get("post");
        String email=stringMap.get("email");
        String name=stringMap.get("name");
        String file=stringMap.get("file");
        String profilePic=stringMap.get("profilePic");

        Post post=
                Post.builder()
                        .post(reqPost)
                        .email(email)
                        .file(file)
                        .name(name)
                        .profilePic(profilePic)
                        .timeStamp(new Date().toString())
                        .build();

        post=postService.addPost(post);
        return post;
    }

    @GetMapping
    public List<Post> getAllPost(){
        return postService.getAllPost();
    }
}
