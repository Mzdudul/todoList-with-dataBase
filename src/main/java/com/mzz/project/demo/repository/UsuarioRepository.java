package com.mzz.project.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.mzz.project.demo.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    
} 
