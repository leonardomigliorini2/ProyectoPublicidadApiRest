package com.ProyectoPublicidadApi.Rest.Repository;

import com.ProyectoPublicidadApi.Rest.Entidades.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {

}
