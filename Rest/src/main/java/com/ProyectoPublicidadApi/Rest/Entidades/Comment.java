package com.ProyectoPublicidadApi.Rest.Entidades;


import jakarta.persistence.*;


import java.util.Date;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "LONGTEXT")
    private String contenido;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UserEntity userEntity;
    @Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date fecha;

    public Comment() {
    }

    public Comment(Long id, String contenido, UserEntity userEntity, Date fecha) {
        this.id = id;
        this.contenido = contenido;
        this.userEntity = userEntity;
        this.fecha = fecha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
