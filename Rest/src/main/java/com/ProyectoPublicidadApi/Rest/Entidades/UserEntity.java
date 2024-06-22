package com.ProyectoPublicidadApi.Rest.Entidades;

import jakarta.persistence.*;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private String contact;
    private String address; //telefono
    @OneToOne
    private Imagen image;

    public UserEntity() {
    }

    public UserEntity(String name, Long id, String lastName, String password, String email, String address, String contact, Imagen image) {
        this.name = name;
        this.id = id;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.address = address;
        this.contact = contact;
        this.image = image;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Imagen getImage() {
        return image;
    }

    public void setImage(Imagen image) {
        this.image = image;
    }
}
