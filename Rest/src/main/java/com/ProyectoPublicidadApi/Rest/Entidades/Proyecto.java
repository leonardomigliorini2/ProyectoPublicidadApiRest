package com.ProyectoPublicidadApi.Rest.Entidades;

import jakarta.persistence.*;

@Entity
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String propietario;
    @Column
    private String nombre;
    @Column
    private String descripcion;
    @OneToOne
    private ArchivoAdjunto archivoAdjunto;

    public Proyecto() {
    }

    public Proyecto(Long id, String propietario, String nombre, String descripcion, ArchivoAdjunto archivoAdjunto) {
        this.id = id;
        this.propietario = propietario;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.archivoAdjunto=archivoAdjunto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArchivoAdjunto getArchivoAdjunto() {
        return archivoAdjunto;
    }

    public void setArchivoAdjunto(ArchivoAdjunto archivoAdjunto) {
        this.archivoAdjunto = archivoAdjunto;
    }
}
