package com.ProyectoPublicidadApi.Rest.Entidades;

import jakarta.persistence.*;

@Entity
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String type;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] content;

    public File() {
    }

    public File(Long id, String name, String type, byte[] content) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getContent(byte[] bytes) {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
