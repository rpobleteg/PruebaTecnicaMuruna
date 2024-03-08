/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.prueba.tecnica.repository;

/**
 *
 * @author Ricar
 */
import com.example.prueba.tecnica.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.prueba.tecnica.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM UsuarioEntity u WHERE u.email = ?1")
    boolean existsByEmail(String email);
}