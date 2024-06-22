package com.ProyectoPublicidadApi.Rest.Service;

import com.ProyectoPublicidadApi.Rest.Entidades.Imagen;
import com.ProyectoPublicidadApi.Rest.Repository.ImagenRepository;
import com.ProyectoPublicidadApi.Rest.exceptions.MyExceptions;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceImagen {
    @Autowired
    private ImagenRepository imagenRepositorio;

    @Transactional
    public Imagen createImagen(MultipartFile request) throws MyExceptions, IOException {

        if (request != null) {
            try {
                Imagen imagen = new Imagen();
                imagen.setTipo(request.getContentType());
                imagen.setNombre(request.getName());
                imagen.setContenido(request.getBytes());
                return imagenRepositorio.save(imagen);
            } catch (Exception e) {
                new MyExceptions("error el archivo esta vacio o es nulo");
            }
        }else {throw new MyExceptions("el archivo es nulo");};
        return null;
    }

    public List ImagenList() {
        List list = imagenRepositorio.findAll();
        return list;
    }

    @Transactional
    public Imagen UpdateImage(MultipartFile archivo, Long id) throws MyExceptions, IOException {
        if (archivo != null) {
            Optional<Imagen> response = imagenRepositorio.findById(id);
            if (response.isPresent()) {
                Imagen image = new Imagen();
                image=imagenRepositorio.getById(id);
                image.setTipo(archivo.getContentType());
                image.setNombre(archivo.getName());
                image.setContenido(archivo.getBytes());
                return imagenRepositorio.save(image);
            }
        }
        return null;
    }

    @Transactional
    public String DeleteImage(long id) throws MyExceptions {
        Optional<Imagen> response = imagenRepositorio.findById(id);

        if (response.isPresent()) {
            Imagen imagen=imagenRepositorio.getById(id);
            imagenRepositorio.delete(imagen);
            return "la imagen fue elimanda";
        } else {
            throw new MyExceptions("La imagen con el ID proporcionado no existe.");
        }
    }



}
