package com.ProyectoPublicidadApi.Rest.Service;



import com.ProyectoPublicidadApi.Rest.Entidades.UserEntity;
import com.ProyectoPublicidadApi.Rest.Repository.CommentRepository;
import com.ProyectoPublicidadApi.Rest.Repository.UserEntityRepository;
import com.ProyectoPublicidadApi.Rest.exceptions.MyExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
public class ServiceUserEntity {
@Autowired
private UserEntityRepository userEntityRepository;
@Autowired
private CommentRepository commentRepository;

public List<UserEntity>ListUsers(){
    return this.userEntityRepository.findAll();
}

@Transactional
public String CrearUserEntity(UserEntity request)throws MyExceptions{
        validacion(request);
        UserEntity userEntity=new UserEntity();
        userEntity.setName(request.getName());
        userEntity.setAddress(request.getAddress());
        userEntity.setContact(request.getContact());
        userEntity.setEmail(request.getEmail());
        userEntity.setLastName(request.getLastName());
        userEntity.setPassword(request.getPassword());
        userEntity.setImage(request.getImage());
        userEntity.setComents(request.getComents());
        userEntityRepository.save(userEntity);
        return "se creo en la base de datos un nuevo usuario exitosamente";

}
public void validacion(UserEntity request) throws MyExceptions {
    if (request.getName().isEmpty()||request.getName()==null){
        throw new MyExceptions("el nombre esta vacio o es nulo");
    }
    if (request.getLastName().isEmpty()||request.getLastName()==null){
        throw new MyExceptions("el apellido esta vacio o es nulo");
    }
    if (request.getAddress().isEmpty()|| request.getAddress()==null){
        throw new MyExceptions("la direccion esta vacia o es nula");
    }
    if (request.getEmail().isEmpty()||request.getEmail()==null){
        throw new MyExceptions("el mail esta vacio o es nulo");
    }
    if (request.getContact().isEmpty()||request.getContact()==null){
        throw new MyExceptions("el contacto esta vacio o es nulo");
    }
    if (request.getPassword().isEmpty()||request.getPassword()==null){
        throw new MyExceptions("la contraseña esta vacia o es nula");
    }
   if (request.getComents().isEmpty()|| request.getComents()==null){
        throw new MyExceptions("la lista de comentarios esta vacia o es nula");
    };
}
@Transactional
public String modificarUserEntity(Long id,UserEntity request)throws MyExceptions{
    Optional<UserEntity>exist=userEntityRepository.findById(id);
    if (exist.isPresent()){
        validacion(request);
        UserEntity userEntity=userEntityRepository.getById(id);
        userEntity.setAddress(request.getAddress());
        userEntity.setContact(request.getContact());
        userEntity.setEmail(request.getEmail());
        userEntity.setName(request.getName());
        userEntity.setLastName(request.getLastName());
        userEntity.setPassword(request.getPassword());
        userEntity.setImage(request.getImage());
        userEntity.setComents(request.getComents());
        userEntityRepository.save(userEntity);
        return "se ha modificado con exito el usuario en la base de datos";
    }else {throw new MyExceptions("el id no corresponde a un usuario de la base de datos");}
    }
@Transactional
public String eliminarUserEntity(Long id) throws MyExceptions {
    Optional<UserEntity>exist=userEntityRepository.findById(id);

    if (exist.isPresent()){
        UserEntity user=userEntityRepository.getById(id);
        this.userEntityRepository.delete(user);
        return "el usuario se ha eliminado de la base de datos";
    }else {throw new MyExceptions("el usuario no existe en la base de datos y no se ha podido eliminar");}

}
}
