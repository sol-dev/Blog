package com.example.blog.controllers;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import com.example.blog.entities.Post;
import com.example.blog.services.IPostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
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

    /*    GET /posts/:id
    Deberá buscar un post cuyo id sea el especificado en el parámetro :id. Si existe, devolver sus
    detalles, caso contrario devolver un mensaje de error con el código de estado HTTP que
    corresponda.    */
    @GetMapping(value="/id")
    public Post findById(@RequestParam("id") int id){
        return postService.findById(id);
        //agregar validacion
    }




    /*    POST /posts
    Deberá guardar un nuevo post según los datos recibidos en la petición. */
    @PostMapping(value="/new" , consumes = "application/json")
    public String newPost(@RequestBody Post post){
        Date created_at = new Date();
        post.setCreated_at(created_at);
        postService.savePost(post);
        return "index";
        //HttpStatus.
    }


    /*  PATCH /posts/:id
    Deberá actualizar el post con el id especificado en el parámetro :id, y actualizar sus datos
    según el cuerpo de la petición. En el caso de que no exista, devolver un mensaje de error.  */
    //buscar sobre patch

    
    /*    DELETE /posts/:id
    Deberá eliminar el post con el id especificado en el parámetro :id. En el caso de que no exista,
    devolver un mensaje de error.   */
    @DeleteMapping(value="/delete")
    public void deletePost(@RequestParam("id") int id){
        postService.delete(id);
    }


    
    
}
