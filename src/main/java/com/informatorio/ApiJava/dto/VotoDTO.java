package com.informatorio.ApiJava.dto;

import java.time.LocalDateTime;
import com.informatorio.ApiJava.entity.Generado;

public class VotoDTO {
    private Generado generado;
    private Long usuarioId;
    private Long emprendimientoId;
    private LocalDateTime fechaCreacion;
    private boolean votado;
    
    public Generado getGenerado() {
        return generado;
    }
    public void setGenerado(Generado generado) {
        this.generado = generado;
    }
    public Long getUsuarioId() {
        return usuarioId;
    }
    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
    public Long getEmprendimientoId() {
        return emprendimientoId;
    }
    public void setEmprendimientoId(Long emprendimientoId) {
        this.emprendimientoId = emprendimientoId;
    }
    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }
    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    public boolean isVotado() {
        return votado;
    }
    public void setVotado(boolean votado) {
        this.votado = votado;
    }
}