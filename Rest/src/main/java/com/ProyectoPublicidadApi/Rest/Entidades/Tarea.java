package com.ProyectoPublicidadApi.Rest.Entidades;



import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(schema = "TareaCrud")
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTarea;
    @Column
    private String nombre;
    @Column
    private String estadoTarea;
    @Column
    private String agente;
    @ElementCollection
    private List<Proyecto> Proyectos;
    @ElementCollection
    private List<String> comentario;

    public Tarea() {
    }

    public Tarea(Long idTarea, String nombre, String estadoTarea, String agente, List<Proyecto> proyectos, List<String> comentario) {
        this.idTarea = idTarea;
        this.nombre = nombre;
        this.estadoTarea = estadoTarea;
        this.agente = agente;
        Proyectos = proyectos;
        this.comentario = comentario;
    }

    public Long getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(Long idTarea) {
        this.idTarea = idTarea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstadoTarea() {
        return estadoTarea;
    }

    public void setEstadoTarea(String estadoTarea) {
        this.estadoTarea = estadoTarea;
    }

    public String getAgente() {
        return agente;
    }

    public void setAgente(String agente) {
        this.agente = agente;
    }

    public List<Proyecto> getProyectos() {
        return Proyectos;
    }

    public void setProyectos(List<Proyecto> proyectos) {
        Proyectos = proyectos;
    }

    public List<String> getComentario() {
        return comentario;
    }

    public void setComentario(List<String> comentario) {
        this.comentario = comentario;
    }
}

