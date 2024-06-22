package com.ProyectoPublicidadApi.Rest.Controller;

import com.ProyectoPublicidadApi.Rest.Entidades.ArchivoAdjunto;
import com.ProyectoPublicidadApi.Rest.Service.ServiceArchivoAdjunto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArchivoAdjuntoController {
    @Autowired
    private ServiceArchivoAdjunto archivoService;

    @GetMapping(value = "/ListaArchivos")
    public List ListaArchivos() {
        return this.archivoService.ListaDeArchivos();
    }

    @PostMapping(value = "/crearArchivo")
    @ResponseStatus(HttpStatus.CREATED)
    public String CreateFile(@RequestBody ArchivoAdjunto request) throws Exception {
        this.archivoService.CreateFile(request);
        return "Archivo creado";}

    @PutMapping(value = "/escribirArchivo/{id}")
    public String WriteFile (@PathVariable Long id,@RequestBody ArchivoAdjunto request) throws  Exception {
        this.archivoService.WriteFile(id,request);
        return "el archivo fue se escribio";
    }

    @DeleteMapping(value = "/borrarArchivo/{id}")
    public String deleteFile (@PathVariable Long id) throws Exception {
        return this.archivoService.DeleteFile(id);
    }
    }
