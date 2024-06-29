package com.ProyectoPublicidadApi.Rest.Controller;

import com.ProyectoPublicidadApi.Rest.Entidades.UserEntity;
import com.ProyectoPublicidadApi.Rest.Service.ServiceComment;
import com.ProyectoPublicidadApi.Rest.Service.ServiceUserEntity;
import com.ProyectoPublicidadApi.Rest.exceptions.MyExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserEntityController {
    @Autowired
    private ServiceUserEntity usuarioServicio;
    @Autowired
    private ServiceComment serviceCommentment;

    @GetMapping(value = "/listaUsuarios")
    public List<UserEntity> ListUsers(){
    return this.usuarioServicio.ListUsers();
    }
    @PostMapping(value = "/crearUsuario")
    public String CrearUsuarios(@RequestBody UserEntity request) throws MyExceptions {
        this.usuarioServicio.CrearUserEntity(request);
        return "se ha creado un nuevo usuario";
    }
    @PutMapping(value = "/modificarUsuario/{id}")
    public String modificarUsuario(@PathVariable Long id, @RequestBody UserEntity request) throws MyExceptions {
        this.usuarioServicio.modificarUserEntity(id,request);
        return "el usuario se ha modificado";
    }
    @DeleteMapping(value = "/eliminarUsuario/{id}")
    public String eliminarusuario(@PathVariable Long id) throws MyExceptions{

        this.usuarioServicio.eliminarUserEntity(id);
        return "se ha eliminado el usuario";
    }
}
