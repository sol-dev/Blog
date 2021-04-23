package com.example.blog.controllers;

import java.util.Date;
import java.util.List;
import com.example.blog.entities.Post;
import com.example.blog.services.IPostService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@RestController
@Controller
@RequestMapping("/posts")
public class PostController {

    //service
    @Autowired
    @Qualifier("postService")
    private IPostService postService;

    
    /*  GET /posts
    Deberá mostrar un listado de posts, ordenados por fecha de creación descendente. Este listado
    deberá mostrar todos los campos excepto “Contenido”.    */
    @GetMapping(value = "/all")
    public List<Post> findAll(){
        return postService.findAllSorted();
    }

    //index
    @GetMapping(value = "/home")
    public String home(Model model){
        model.addAttribute("post_list",postService.findAllSorted() );
        return "index";
    }

    /*    GET /posts/:id
    Deberá buscar un post cuyo id sea el especificado en el parámetro :id. Si existe, devolver sus
    detalles, caso contrario devolver un mensaje de error con el código de estado HTTP que
    corresponda.    */
    @GetMapping(value="/id") // http://localhost:8080/posts/id?id=4
    public String findById(@RequestParam("id") int id,Model model){
        model.addAttribute("post", postService.findById(id));
        return "detail";
    }

    /*    POST /posts
    Deberá guardar un nuevo post según los datos recibidos en la petición. */
    @GetMapping(value = "/nuevo")
    public String viewNewPost(){
        return "new";
    }
   
    @PostMapping(value="/new")
    public void newPost(@ModelAttribute("new_post") Post post){
        Date created_at = new Date();
        post.setCreated_at(created_at);
        postService.savePost(post);
    }

    /*
    @PostMapping(value="/new" , consumes = "application/json")
    public String newPost(@RequestBody Post post){
        Date created_at = new Date();
        post.setCreated_at(created_at);
        postService.savePost(post);
        return "index";
    }*/

    
    /*    DELETE /posts/:id
    Deberá eliminar el post con el id especificado en el parámetro :id. En el caso de que no exista,
    devolver un mensaje de error.   */
    @DeleteMapping(value="/delete")
    public void deletePost(@RequestParam("id") int id){
        postService.delete(id);
    }
 
    
}
