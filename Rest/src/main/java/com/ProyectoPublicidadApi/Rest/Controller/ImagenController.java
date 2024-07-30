package com.ProyectoPublicidadApi.Rest.Controller;

import com.ProyectoPublicidadApi.Rest.Entidades.Imagen;
import com.ProyectoPublicidadApi.Rest.Service.ServiceImagen;
import com.ProyectoPublicidadApi.Rest.exceptions.MyExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class ImagenController {
    @Autowired
    private ServiceImagen imageService;


    @PostMapping("/create")
    public String createImage(@RequestParam("Imagen[]") MultipartFile request) throws MyExceptions, IOException {
        imageService.createImagen(request);
        return "la imagen ha sido creada";
    }

    @GetMapping(value = "/listaImagenes")
    public List<Imagen> listImages() {
        return imageService.ImagenList();
    }


    @PutMapping(value = "/update/{id}")
    public String  updateImage(@PathVariable Long id, @RequestParam("Imagen[]") MultipartFile archivo) throws MyExceptions, IOException {
        imageService.UpdateImage(archivo, id);
        return "La imagen ha sido actualizada";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteImage(@PathVariable Long id) throws MyExceptions {
        imageService.DeleteImage(id);
    return "la imagen ha sido eliminada";
    }

}
