package com.ProyectoPublicidadApi.Rest.Service;


import com.ProyectoPublicidadApi.Rest.Entidades.Proyecto;
import com.ProyectoPublicidadApi.Rest.Repository.ProyectoRepository;
import com.ProyectoPublicidadApi.Rest.Repository.TareaRepository;
import com.ProyectoPublicidadApi.Rest.Entidades.Tarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceTarea {
    @Autowired
    protected TareaRepository tareareposirio;
    @Autowired
    protected ProyectoRepository proyect;
    @Transactional
    public Tarea CreateTarea(Tarea request)
            throws Exception {

        Validacion(request.getNombre(), request.getEstadoTarea(), request.getAgente());
        Tarea tarea = new Tarea();
        tarea.setNombre(request.getNombre());
        tarea.setEstadoTarea(request.getEstadoTarea());
        tarea.setProyectos(request.getProyectos());
        tarea.setAgente(request.getAgente());
        tareareposirio.save(tarea);

        return tarea;
    }

    public void Validacion(String nombre,
                           String estadoTarea,
                           String agente
    )
            throws Exception {
        if (nombre.isEmpty() || nombre == null) {
            throw new Exception("el nombre esta vacio o es nulo.");
        }
        if (estadoTarea == null) {
            throw new Exception("el estado no puede ser nulo");
        }

        if (agente == null) {
            throw new Exception("el agente esta vacio o es nulo");
        }

    }

    @Transactional
    public String UpdateTarea(Long idTarea, Tarea request) throws Exception {
        Validacion(request.getNombre(), request.getEstadoTarea(), request.getAgente());
        Optional<Tarea> existe = tareareposirio.findById(idTarea);
        if (existe.isPresent()) {
            Tarea tarea = tareareposirio.getById(idTarea);
            tarea.setNombre(request.getNombre());
            tarea.setEstadoTarea(request.getEstadoTarea());
            tarea.setProyectos(request.getProyectos());
            tarea.setAgente(request.getAgente());
            tareareposirio.save(tarea);
            return "la tarea ha sido modificada";
        } else {
            throw new Exception("la tarea no existe");}


        }
        public List tareasList () {
            List list = tareareposirio.findAll();
            return list;
        }
        @Transactional
        public Boolean deleteTarea (Long idtarea)throws Exception {
            Optional<Tarea> tarea = tareareposirio.findById(idtarea);
            if (tarea.isPresent()) {
                this.tareareposirio.deleteById(idtarea);
                return true;
            } else {
                throw new Exception("el id no corresponde a una tarea existente");
            }
        }

    }

