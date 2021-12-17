package com.info21.ApiRestJava.controller;

import com.info21.ApiRestJava.dto.VotoDTO;
import com.info21.ApiRestJava.service.VotoService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/votos")
public class VotoController {
    private final VotoService votoService;
    @Autowired
    public VotoController(VotoService votoService) {
        this.votoService = votoService;
    }

    @PostMapping
    public ResponseEntity<?> crearVoto(@Valid @RequestBody VotoDTO votoDTO) {
        return new ResponseEntity<>(votoService.crearVoto(votoDTO), HttpStatus.CREATED);
    }
    @GetMapping(value = "/{usuarioId}")
    public ResponseEntity<?> obtenerLosVotosDeUnUsuario(@PathVariable("usuarioId") Long usuarioId) {
        return new ResponseEntity<>(votoService.obtenerVotos(usuarioId), HttpStatus.OK);
    }
} 