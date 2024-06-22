package com.ProyectoPublicidadApi.Rest.Repository;

import com.ProyectoPublicidadApi.Rest.Entidades.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagenRepository extends JpaRepository<Imagen, Long> {
}
