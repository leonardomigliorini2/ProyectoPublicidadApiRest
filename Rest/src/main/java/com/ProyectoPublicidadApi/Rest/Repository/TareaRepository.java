package com.ProyectoPublicidadApi.Rest.Repository;

import com.ProyectoPublicidadApi.Rest.Entidades.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaRepository extends JpaRepository<Tarea, Long> {
}
