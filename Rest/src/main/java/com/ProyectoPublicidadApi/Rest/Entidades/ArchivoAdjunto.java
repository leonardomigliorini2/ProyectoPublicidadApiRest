package com.ProyectoPublicidadApi.Rest.Entidades;


import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;


@Entity
public class ArchivoAdjunto {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @Column
   private String nombre;
   @Column
   private String tipo;
   @Lob
   @Basic(fetch = FetchType.LAZY)
   @Column
   private String contenido;

    public ArchivoAdjunto() {
    }

    public ArchivoAdjunto(Long id, String nombre, String tipo, String contenido) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.contenido = contenido;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}
