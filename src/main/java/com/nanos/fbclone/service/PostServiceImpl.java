package com.nanos.fbclone.service;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.nanos.fbclone.entity.PostEntity;
import com.nanos.fbclone.model.Post;
import com.nanos.fbclone.repository.PostEntityRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {

    private PostEntityRepository postEntityRepository;
    @Override
    public Post addPost(Post post) throws Exception {
        try {
            PostEntity postEntity= new PostEntity();
            BeanUtils.copyProperties(post,postEntity);

            if(post.getFile()!=null &&!post.getFile().equalsIgnoreCase("null"))
                postEntity.setImage(post.getFile());
            else
                postEntity.setImage(null);

            postEntity=postEntityRepository.save(postEntity);
            post.setId(postEntity.getId());
            post.setFile(null);
            post.setImage(postEntity.getImage());
        }catch (Exception e){
            throw new Exception("Could not save post");
        }

        return post;
    }

    @Override
    public List<Post> getAllPost() {
        List<PostEntity> postEntities = postEntityRepository.findAll();
        List<Post> posts = new ArrayList<>();
        posts=postEntities.stream().map((postEntity)->{
            return Post.builder().
                    timeStamp(postEntity.getTimeStamp())
                    .email(postEntity.getEmail())
                    .post(postEntity.getPost())
                    .image(postEntity.getImage())
                    .name(postEntity.getName())
                    .id(postEntity.getId())
                    .profilePic(postEntity.getProfilePic())
                    .build();

        }).collect(Collectors.toList());
        return posts;
    }
}
