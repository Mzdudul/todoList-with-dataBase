package com.mzz.project.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mzz.project.demo.model.Tarefas;
import com.mzz.project.demo.model.Usuario;



@Repository
public interface TarefasRepository extends JpaRepository<Tarefas, Long> {

   

    
} 