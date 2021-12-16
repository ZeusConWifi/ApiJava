package com.informatorio.ApiJava.repository;

import com.informatorio.ApiJava.entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {   
}