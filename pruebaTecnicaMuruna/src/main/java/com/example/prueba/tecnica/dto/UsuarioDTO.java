/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.prueba.tecnica.dto;

import java.util.List;
import com.example.prueba.tecnica.dto.Phone;

/**
 *
 * @author Ricar
 */
public class UsuarioDTO {

    private String nombre;
    private String email;
    private String password;
    private List<Phone> phones; // Suponiendo que tienes un DTO para los teléfonos

    // Constructor vacío
    public UsuarioDTO() {
    }

    // Constructor con todos los campos
    public UsuarioDTO(String nombre, String email, String password, List<Phone> phones) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.phones = phones;
    }

    // Getters y setters para todos los campos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
}
