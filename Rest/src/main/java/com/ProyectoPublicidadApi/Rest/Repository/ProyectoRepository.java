package com.ProyectoPublicidadApi.Rest.Repository;

import com.ProyectoPublicidadApi.Rest.Entidades.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {
}
