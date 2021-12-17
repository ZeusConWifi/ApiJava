package com.info21.ApiRestJava.service;

import com.info21.ApiRestJava.dto.VotoDTO;
import com.info21.ApiRestJava.entity.Emprendimiento;
import com.info21.ApiRestJava.entity.Voto;
import com.info21.ApiRestJava.repository.EmprendimientoRepository;
import com.info21.ApiRestJava.repository.VotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VotoService {
    private final EmprendimientoRepository emprendimientoRepository;
    private final Converter<VotoDTO, Voto> votoDTOVotoConverter;
    private final VotoRepository votoRepository;
    @Autowired
    public VotoService(EmprendimientoRepository emprendimientoRepository, 
                       Converter<VotoDTO, Voto> votoDTOVotoConverter, 
                       VotoRepository votoRepository) {
        this.emprendimientoRepository = emprendimientoRepository; 
        this.votoDTOVotoConverter = votoDTOVotoConverter;
        this.votoRepository = votoRepository;
    }
    public boolean chequearVoto(VotoDTO votoDTO){
        Voto voto = votoDTOVotoConverter.convert(votoDTO);
        return votoRepository.findAll().stream().anyMatch(v -> {
            assert voto != null;
            return v.getUsuarioId().equals(voto.getUsuarioId()) && v.getEmprendimientoId().equals(voto.getEmprendimientoId());
        });
    }
    public Boolean crearVoto(VotoDTO votoDTO) {
        Voto voto = votoDTOVotoConverter.convert(votoDTO);
        if(!chequearVoto(votoDTO)){
            assert voto != null;
            Emprendimiento emprendimiento = emprendimientoRepository.getById(voto.getEmprendimientoId());
            emprendimiento.setContadorDeVotos(emprendimiento.getContadorDeVotos()+1);
            emprendimientoRepository.save(emprendimiento);
            votoRepository.save(voto);
            return true;
        }
        return false;
    }
    public List<Voto> obtenerVotos(Long usuarioId) {
        return votoRepository.findByUsuarioId(usuarioId);
    }   
}