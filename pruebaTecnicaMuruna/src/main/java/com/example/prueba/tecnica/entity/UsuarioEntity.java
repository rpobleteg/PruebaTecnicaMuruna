package com.example.prueba.tecnica.entity;

import java.time.LocalDateTime;

import java.util.List;

import com.example.prueba.tecnica.dto.Phone;

import jakarta.persistence.Entity; // Importa el decorador @Entity
import jakarta.persistence.Table; // Importa el decorador @Table
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.JoinColumn;

@Entity //Hibernate decorador.
@Table(name = "usuarios") // Nombre de tabla
public class UsuarioEntity {

    @Id
    private String id;
    
    @Column 
    private String name;

    @Column(unique = true)
    private String email;
    
    @Column
    private String password;

    @ElementCollection
    @CollectionTable(name = "phones", joinColumns = @JoinColumn(name = "usuario_id"))
    @Column(name = "phones")
    private List<Phone> phones;
    
    @Column
    private String token;

    @Column
    private LocalDateTime created;
    
    @Column
    private LocalDateTime modified;
    
    @Column
    private LocalDateTime lastLogin;
    
    @Column
    private boolean active;

    // Constructor, getters y setters
    // Constructor vacío
    public UsuarioEntity() {
    }

    // Getters y setters para todos los campos
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return name;
    }

    public void setNombre(String name) {
        this.name = name;
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

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
