package com.ProyectoPublicidadApi.Rest.Service;

import com.ProyectoPublicidadApi.Rest.Entidades.*;
import com.ProyectoPublicidadApi.Rest.Repository.CommentRepository;
import com.ProyectoPublicidadApi.Rest.Repository.UserEntityRepository;
import com.ProyectoPublicidadApi.Rest.exceptions.MyExceptions;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
public class ServiceComment {
    @Autowired
    private CommentRepository commentRepository;


    @Transactional
    public String createComment(Comment request)throws MyExceptions {

        Validacion(request);
        try{
        Comment comment = new Comment();
        comment.setFecha(request.getFecha());
        comment.setContenido(request.getContenido());
        comment.setUserEntity(request.getUserEntity());
        commentRepository.save(comment);
        return "se ha guardado un comentario exitosamente en la base de datos";}
        catch (Exception e){
            throw new MyExceptions("hubo un error: "+e.getMessage());
        }
    }

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @Transactional
    public String updateComment(Long id, Comment request) throws MyExceptions {
        Optional<Comment> op= commentRepository.findById(id);
        if (op.isPresent()){
        Comment comment=commentRepository.getById(id);
        comment.setContenido(request.getContenido());
        comment.setFecha(request.getFecha());
        comment.setUserEntity(request.getUserEntity());
        commentRepository.save(comment);
        return "se han guardado exitosamente los cambios en la base de datos";}
        else {throw new MyExceptions("el id no corresponde a ningún comentario");}

    }
    @Transactional
    public String deleteComment(Long id) throws MyExceptions{
        try {
            Optional<Comment>comentario=commentRepository.findById(id);
            if (comentario.isPresent()){
            Comment comment = commentRepository.getById(id);
            commentRepository.delete(comment);
            return "se ha eliminado de la base de datos el comentario exitosamente";}
            else {throw new MyExceptions("error, el comentario no corresponde al id");}
        }catch (Exception e){
            throw new MyExceptions(e.getMessage());
        }

    }
public void Validacion(Comment request) throws MyExceptions {
    if (request.getContenido() == null || request.getContenido().isEmpty()) {
        throw new MyExceptions("el contenido es nulo o esta vacio");
    }

    if (request.getFecha() == null) {
        throw new MyExceptions("la fecha es nulo o es inexistente");
    }
    if (request.getUserEntity()==null){
        throw new MyExceptions("el usuario es nulo");
    }
}

}
