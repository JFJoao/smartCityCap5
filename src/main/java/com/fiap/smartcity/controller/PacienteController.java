package com.fiap.smartcity.controller;

import com.fiap.smartcity.model.Paciente;
import com.fiap.smartcity.service.PacienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
@Api(value = "Pacientes", tags = "Paciente Controller", description = "Operações relacionadas a pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    @ApiOperation(value = "Adiciona um novo paciente", notes = "Forneça as informações do paciente para inserção")
    public ResponseEntity<Paciente> adicionarPaciente(@RequestBody Paciente paciente) {
        Paciente novoPaciente = pacienteService.adicionarPaciente(paciente);
        return new ResponseEntity<>(novoPaciente, HttpStatus.CREATED);
    }

    @GetMapping
    @ApiOperation(value = "Lista todos os pacientes")
    public ResponseEntity<List<Paciente>> listarPacientes() {
        List<Paciente> pacientes = pacienteService.listarPacientes();
        return new ResponseEntity<>(pacientes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Busca um paciente pelo ID")
    public ResponseEntity<Paciente> buscarPacientePorId(@PathVariable String id) {
        Paciente paciente = pacienteService.buscarPorId(id);
        return paciente != null ?
                new ResponseEntity<>(paciente, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Atualiza um paciente existente")
    public ResponseEntity<Paciente> atualizarPaciente(@PathVariable String id, @RequestBody Paciente pacienteAtualizado) {
        Paciente paciente = pacienteService.atualizarPaciente(id, pacienteAtualizado);
        return paciente != null ?
                new ResponseEntity<>(paciente, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Remove um paciente pelo ID")
    public ResponseEntity<Void> removerPaciente(@PathVariable String id) {
        pacienteService.removerPaciente(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
