package com.ProyectoPublicidadApi.Rest.Service;

import com.ProyectoPublicidadApi.Rest.Entidades.File;
import com.ProyectoPublicidadApi.Rest.Repository.FileRepository;
import com.ProyectoPublicidadApi.Rest.exceptions.MyExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class FileService {
    @Autowired
    private FileRepository fileRepository;

    public List<File> fileList() {
        return this.fileRepository.findAll();
    }

    @Transactional
    public String creatFile(MultipartFile request) throws MyExceptions, IOException {
        if (request != null) {
            File file = new File();
            file.setName(request.getName());
            file.setType(request.getContentType());
            file.setContent(request.getBytes());
            this.fileRepository.save(file);
            return "file have been saved on data base";
        } else throw new MyExceptions("file is null");
    }

    @Transactional
    public String upDateFile(MultipartFile request, Long id) throws MyExceptions, IOException {
        Optional<File> fileIsPresent = this.fileRepository.findById(id);
        if (fileIsPresent.isPresent()) {
            File file = fileRepository.getById(id);
            file.setName(request.getName());
            file.setType(request.getContentType());
            file.getContent(request.getBytes());
            this.fileRepository.save(file);
            return "file have been saved on data base";
        } else {
            throw new MyExceptions("id is not exist on data base");
        }
    }

    @Transactional
    public String deleteFile(Long id) throws MyExceptions {
        Optional<File> FileIsPresent = this.fileRepository.findById(id);
        if (FileIsPresent.isPresent()) {
            this.fileRepository.deleteById(id);
            return "file have been deleted";
        } else if (id == null) {
            throw new NullPointerException("id is null");
        } else {
            throw new MyExceptions("id is not exist on data base");
        }

    }

}
