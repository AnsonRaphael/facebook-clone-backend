package com.nanos.fbclone.service;

import com.nanos.fbclone.model.Post;

import java.util.List;

public interface PostService {
    Post addPost(Post post) throws Exception;

    List<Post> getAllPost();
}
