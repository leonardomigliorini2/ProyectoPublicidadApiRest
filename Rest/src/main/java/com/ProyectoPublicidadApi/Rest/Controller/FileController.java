package com.ProyectoPublicidadApi.Rest.Controller;

import com.ProyectoPublicidadApi.Rest.Entidades.File;
import com.ProyectoPublicidadApi.Rest.Repository.FileRepository;
import com.ProyectoPublicidadApi.Rest.Service.FileService;
import com.ProyectoPublicidadApi.Rest.exceptions.MyExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class FileController {
    @Autowired
    private FileService fileService;

    @GetMapping(value = "/listFile")
    public List<File> listFile(){
      return this.fileService.fileList();
    }
    @PostMapping(value = "/createFile")
    public String createFile(@RequestParam("File") MultipartFile request) throws Exception{
        this.fileService.creatFile(request);
        return "file have been created";
    }
    @PutMapping(value = "/upDateFile/{id}")
    public String upDateFile(@PathVariable Long id,@RequestParam("File") MultipartFile request)throws Exception{
        this.fileService.upDateFile(request, id);
        return "File have been update";
    }
    @DeleteMapping(value = "/deleteFile/{id}")
    public String deleteFile(@PathVariable Long id)throws MyExceptions {
        this.fileService.deleteFile(id);
        return "file have been deleted";
    }
}
