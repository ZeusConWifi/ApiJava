package com.info21.ApiRestJava.repository;

import java.util.List;
import com.info21.ApiRestJava.entity.Voto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotoRepository extends JpaRepository<Voto, Long> {
    List<Voto> findByUsuarioId(Long usuarioId);
}