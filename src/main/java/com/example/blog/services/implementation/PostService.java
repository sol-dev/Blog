package com.example.blog.services.implementation;

import java.util.List;

import com.example.blog.entities.Post;
import com.example.blog.repository.IPostRepository;
import com.example.blog.services.IPostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("postService")
public class PostService implements IPostService{

    @Autowired
    @Qualifier("PostRepository")
    private IPostRepository repository;

    //methods
    public Object savePost(Post post) {
        return repository.saveAndFlush(post);
    }

    public Post findById(int id) {
        return repository.findById(id).get();
    }

    public void delete(Integer id) {
        repository.delete(repository.findById(id).get());
    }

    public List<Post> findAll() {
        return repository.findAll();    
    }
    
    public List<Post> findAllSorted(){
        return repository.findAllSorted();
    }
}
