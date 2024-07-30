package com.ProyectoPublicidadApi.Rest.Service;

import com.ProyectoPublicidadApi.Rest.Entidades.ArchivoAdjunto;
import com.ProyectoPublicidadApi.Rest.Entidades.Imagen;
import com.ProyectoPublicidadApi.Rest.Repository.ArchivoAdjuntoRepository;
import com.ProyectoPublicidadApi.Rest.exceptions.MyExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.*;
import java.io.*;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceArchivoAdjunto {
    @Autowired
    private ArchivoAdjuntoRepository archivoRepository;
    @Transactional
    public ArchivoAdjunto CreateFile(ArchivoAdjunto request)throws Exception {
        Validacion(request.getNombre(), request.getTipo(), request.getContenido());
        File archivo=new File(request.getNombre());
        File Tipo=new File(request.getTipo());

        try {
            PrintWriter Salida=new PrintWriter(archivo);
            PrintWriter SalidaTipo=new PrintWriter(Tipo);
            Salida.close();
            System.out.println("se creo el archivo");
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        }
        ArchivoAdjunto file=new ArchivoAdjunto();
        file.setNombre(archivo.getName());
        file.setTipo(Tipo.getName());

        archivoRepository.save(file);


        return file;
    }
    @Transactional
    public ArchivoAdjunto WriteFile(Long id,ArchivoAdjunto request) throws Exception {
        Validacion(request.getNombre(), request.getContenido(), request.getTipo());
        File archivo = new File(request.getContenido());
        try {

            PrintWriter Salida=new PrintWriter(archivo);
            Salida.close();
            System.out.println("se creo el archivo");

        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        Optional<ArchivoAdjunto> arch = archivoRepository.findById(id);
        ArchivoAdjunto file = new ArchivoAdjunto();
        if (arch.isPresent()) {
            file=archivoRepository.getById(id);
            file.setContenido(request.getContenido());
            archivoRepository.save(file);
        }else {throw new Exception("Error el archivo no existe");}
        return file;
    }



   /* public String readFile(ArchivoAdjunto request) throws Exception {
        Validacion(request.getNombre(), request.getContenido(), request.getTipo());
        File archivo=new File(request.getNombre());
        try {
            BufferedReader read=new BufferedReader(new FileReader(archivo));
            String lectura=read.readLine();
            while (lectura != null){
                System.out.println(lectura);
                lectura=read.readLine();
            }
            read.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        return "La lectura fue realizada";
    }*/
    @Transactional
    public String DeleteFile(Long id) throws MyExceptions {
        Optional<ArchivoAdjunto> file=archivoRepository.findById(id);
        if (file.isPresent()){
            ArchivoAdjunto archivoAdjunto=archivoRepository.getById(id);
            archivoRepository.delete(archivoAdjunto);
        } else {throw new MyExceptions("Error!!, el archivo no esta presente") ;
        }
        return "el archivo fue eliminado";
    }
    public void Validacion(String nombre, String contenido, String Tipo) throws MyExceptions {
        if(nombre.isEmpty() || nombre==null){
            throw new MyExceptions("el archivo debe tener un nombre y no puede ser nulo");
        }
        if (contenido.isEmpty() || contenido==null){
            throw new MyExceptions("el contenido esta vacio o es nulo");
        }
        if (Tipo.isEmpty() || Tipo==null){
            throw new MyExceptions("el tipo esta vacio o es nulo");
        }
    }



    public List ListaDeArchivos(){
        List<ArchivoAdjunto> archivos=archivoRepository.findAll();
    return archivos;

    }
}
