package com.informatorio.ApiJava.converter;

import java.time.LocalDateTime;
import com.informatorio.ApiJava.dto.VotoDTO;
import com.informatorio.ApiJava.entity.Voto;
import com.informatorio.ApiJava.repository.EmprendimientoRepository;
import com.informatorio.ApiJava.repository.UsuarioRepository;
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
        voto.setFechaCreacion(LocalDateTime.now());
        return voto;
    } 
}