package com.info21.ApiRestJava.converter;

import java.time.LocalDateTime;
import com.info21.ApiRestJava.dto.VotoDTO;
import com.info21.ApiRestJava.entity.Voto;
import com.info21.ApiRestJava.repository.EmprendimientoRepository;
import com.info21.ApiRestJava.repository.UsuarioRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class VotoDTOVotoConverter implements Converter<VotoDTO, Voto> {
    public VotoDTOVotoConverter(EmprendimientoRepository emprendimientoRepository,
                                  UsuarioRepository usuarioRepository) {
    }
    @Override
    public Voto convert(VotoDTO votoDto) {
        Voto voto = new Voto();
        voto.setGenerado(votoDto.getGenerado());
        voto.setUsuarioId(votoDto.getUsuarioId());
        voto.setEmprendimientoId(votoDto.getEmprendimientoId());
        voto.setFechaDeCreacion(LocalDateTime.now());
        return voto;
    } 
}