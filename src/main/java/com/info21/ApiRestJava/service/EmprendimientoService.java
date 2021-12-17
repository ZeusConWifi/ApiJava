package com.info21.ApiRestJava.service;

import com.info21.ApiRestJava.entity.Emprendimieto;
import com.info21.ApiRestJava.entity.Tag;
import com.info21.ApiRestJava.entity.Usuario;
import com.info21.ApiRestJava.repository.EmprendimientoRepository;
import com.info21.ApiRestJava.repository.TagRepository;
import com.info21.ApiRestJava.repository.UsuarioRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmprendimientoService {
    private final EmprendimientoRepository emprendimientoRepository;
    private final UsuarioRepository usuarioRepository;
    private final TagRepository tagRepository;
    @Autowired
    public EmprendimientoService(EmprendimientoRepository emprendimientoRepository,
                                 UsuarioRepository usuarioRepository,
                                 TagRepository tagRepository) {
        this.emprendimientoRepository = emprendimientoRepository;
        this.usuarioRepository = usuarioRepository;
        this.tagRepository = tagRepository;
    }

    public Emprendimieto guardar(Long usuarioId, Emprendimieto emprendimiento) {
        Usuario usuario = usuarioRepository.getById(usuarioId);
        emprendimiento.setCreador(usuario);
        return emprendimientoRepository.save(emprendimiento);
    }
    public Emprendimieto eliminar(Long id, Emprendimieto emprendimiento) {
        Emprendimieto emprendimientoEliminado = emprendimientoRepository.getById(id);
        emprendimientoEliminado.setActivo(false);
        return emprendimientoRepository.save(emprendimientoEliminado);
    }
    public Emprendimieto modificar(Long id, Emprendimieto emprendimiento) {
        Emprendimieto emprendimientoModificado = emprendimientoRepository.getById(id);
        if (!emprendimiento.getNombre().trim().isEmpty()) {
            emprendimientoModificado.setNombre(emprendimiento.getNombre()); }
        if (!emprendimiento.getDescripcion().trim().isEmpty()) {
            emprendimientoModificado.setDescripcion(emprendimiento.getDescripcion()); }
        if (!emprendimiento.getContenido().trim().isEmpty()) {
            emprendimientoModificado.setContenido(emprendimiento.getContenido()); }
        if (emprendimiento.getObjetivo() != null && emprendimiento.getObjetivo() > 0) {
            emprendimientoModificado.setObjetivo(emprendimiento.getObjetivo()); }
        if (emprendimiento.isPublicado() != true) { emprendimientoModificado.setPublicado(false); }
        if (emprendimiento.isPublicado() != false) { emprendimientoModificado.setPublicado(true); }
        if (emprendimiento.getUrl() != null) { emprendimientoModificado.setUrl(emprendimiento.getUrl()); }
        if (emprendimiento.getTags() != null) { emprendimientoModificado.setTags(emprendimiento.getTags()); }
        emprendimientoModificado.setUltimaModificacion(LocalDateTime.now());
        return emprendimientoRepository.save(emprendimientoModificado);
    }
    public List<Emprendimieto> obtenerTodos(String nombre) {
        if (nombre != null) { Tag tag = tagRepository.findByNombre(nombre);
            return tag.getEmprendimientos();
        } else { return emprendimientoRepository.findAll(); }
    }
    public Stream<Emprendimieto> obtenerNoPublicados() {
        return emprendimientoRepository.findAll().stream()
            .filter(Predicate.not(Emprendimieto::isPublicado));
    }
}