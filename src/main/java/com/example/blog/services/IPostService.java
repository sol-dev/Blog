package com.example.blog.services;

import java.util.List;

import com.example.blog.entities.Post;

public interface IPostService {
    
    public Object savePost(Post post);

    public Post findById(final int id);

    public void delete(Integer id);

    public List<Post> findAll();

    public List<Post> findAllSorted();
    
    //patch
    public void updatePost(Post post);
}
