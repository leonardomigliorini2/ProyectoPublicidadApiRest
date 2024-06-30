package com.ProyectoPublicidadApi.Rest.Controller;

import com.ProyectoPublicidadApi.Rest.Entidades.*;
import com.ProyectoPublicidadApi.Rest.Repository.UserEntityRepository;
import com.ProyectoPublicidadApi.Rest.Service.ServiceComment;
import com.ProyectoPublicidadApi.Rest.exceptions.MyExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CommentController {
    @Autowired
    private ServiceComment commentService;


    @PostMapping(value="/CrearComentario")
    public String createComment(@RequestBody Comment request) throws MyExceptions{
        commentService.createComment(request);
        return "Comentario Creado exitosamente";
    }



    @GetMapping(value = "/listaComentarios")
    public List<Comment> getAllComments() {
        return commentService.getAllComments();
    }

    // Update
    @PutMapping("/modificarComentario/{id}")
    public String updateComment(@PathVariable Long id, @RequestBody Comment request)throws MyExceptions {
        commentService.updateComment(id, request);
        return "se ha modificado exitosamente el comentario";
    }


    @DeleteMapping("/borrarComentario/{id}")
    public String deleteComment(@PathVariable Long id) throws MyExceptions{
        commentService.deleteComment(id);
        return "el comentario se ha eliminado exitosamente";
    }

}
