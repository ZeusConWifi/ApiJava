package com.info21.ApiRestJava.controller;

import java.time.LocalDateTime;
import javax.validation.Valid;
import com.info21.ApiRestJava.entity.Usuario;
import com.info21.ApiRestJava.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping(value = "api/v1/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;
    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<?>crearUsuario(@Valid @RequestBody Usuario usuario) {
        return new ResponseEntity<>(usuarioService.guardar(usuario), HttpStatus.CREATED);
    }
    @PutMapping(value = "/eliminar/{id}")
    public Usuario eliminarUsuario(@PathVariable("id") Long id, Usuario usuario) {
        return this.usuarioService.eliminar(id, usuario);
    }
    @PutMapping(value = "/{id}")
    public Usuario modificarUsuario(@PathVariable("id") Long id, @Valid @RequestBody Usuario usuario) {
        return this.usuarioService.modificar(id, usuario);
    }
    @GetMapping
    public ResponseEntity<?> obtenerTodosLosUsuarios(@RequestParam(name = "fecha", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaDeCreacion,
            @RequestParam(name = "ciudad", required = false) String ciudad) {
        return new ResponseEntity<>(usuarioService.obtenerTodos(fechaDeCreacion, ciudad), HttpStatus.OK);
    }
}