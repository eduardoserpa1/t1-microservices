package com.microservices.backend_academico.controllers;

import com.microservices.backend_academico.dtos.TurmaDTO;
import com.microservices.backend_academico.models.EstudanteModel;
import com.microservices.backend_academico.models.TurmaModel;
import com.microservices.backend_academico.services.TurmaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/turma")
public class TurmaController {

    @Autowired
    TurmaService turma_service;

    @PostMapping("/create")
    public ResponseEntity<TurmaModel> cadastraTurma(@RequestBody TurmaDTO turmaDTO){
        TurmaModel turmaModel = new TurmaModel();
        BeanUtils.copyProperties(turmaDTO, turmaModel);
        turmaModel.setId_estudante(turmaDTO.getId_estudante());
        turma_service.create(turmaModel);
        return new ResponseEntity<>(turmaModel, HttpStatus.CREATED);
    }
}
