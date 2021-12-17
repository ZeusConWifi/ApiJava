package com.info21.ApiRestJava.repository;

import com.info21.ApiRestJava.entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {   
}