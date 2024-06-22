package com.ProyectoPublicidadApi.Rest.Controller;


import com.ProyectoPublicidadApi.Rest.Entidades.Proyecto;
import com.ProyectoPublicidadApi.Rest.Service.ServiceTarea;
import com.ProyectoPublicidadApi.Rest.Entidades.Tarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TareaController {
    @Autowired
    private ServiceTarea serviceTarea;

    @GetMapping(value ="/")
    public String HolaMundo(){
        return "HolaMundo";
    }
    @GetMapping(value ="/tareas")
    public List<Tarea> GetTareas(){
        return this.serviceTarea.tareasList();
    }
    @PostMapping(value = "/guardarTarea")
    public String SaveTarea(@RequestBody Tarea request) throws Exception {
        this.serviceTarea.CreateTarea(request);
        return "tarea Guardada";
    }
    @PutMapping(value = "/actualizarTarea/{id}")
    public String actualizarTarea(@PathVariable Long id,@RequestBody Tarea tarea) throws Exception {
        this.serviceTarea.UpdateTarea(id,tarea);
        return "tarea actualizada";
         }
    @DeleteMapping(value = "/borrarTarea/{id}")
    public String borrarTarea(@PathVariable Long id) throws Exception {
        this.serviceTarea.deleteTarea(id);
        return "tarea eliminada";
    }
}
