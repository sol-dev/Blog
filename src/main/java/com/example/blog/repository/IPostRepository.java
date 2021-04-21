package com.example.blog.repository;

import java.io.Serializable;
import java.util.List;

import com.example.blog.entities.Post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("PostRepository")
public interface IPostRepository extends JpaRepository<Post, Serializable>{
    
    @Query("SELECT p FROM Post p ORDER BY p.created_at DESC")
    public List<Post> findAllSorted();
}
