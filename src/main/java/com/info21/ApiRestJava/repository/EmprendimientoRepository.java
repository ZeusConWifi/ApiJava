package com.info21.ApiRestJava.repository;

import com.info21.ApiRestJava.entity.Emprendimieto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmprendimientoRepository extends JpaRepository<Emprendimieto, Long> {
}