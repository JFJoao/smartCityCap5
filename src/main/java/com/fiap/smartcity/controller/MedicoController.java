package com.fiap.smartcity.controller;

import com.fiap.smartcity.model.Medico;
import com.fiap.smartcity.repository.MedicoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
@Api(value = "Médicos", tags = "Medico Controller", description = "Operações relacionadas a médicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    @ApiOperation(value = "Adiciona um novo médico")
    public ResponseEntity<Medico> adicionarMedico(@RequestBody Medico medico) {
        Medico novoMedico = medicoRepository.save(medico);
        return new ResponseEntity<>(novoMedico, HttpStatus.CREATED);
    }

    @GetMapping
    @ApiOperation(value = "Lista todos os médicos")
    public ResponseEntity<List<Medico>> listarMedicos() {
        return new ResponseEntity<>(medicoRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Busca um médico pelo ID")
    public ResponseEntity<Medico> buscarPorId(@PathVariable String id) {
        return medicoRepository.findById(id)
                .map(medico -> new ResponseEntity<>(medico, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/especialidade/{especialidade}")
    @ApiOperation(value = "Busca médicos por especialidade")
    public ResponseEntity<List<Medico>> buscarPorEspecialidade(@PathVariable String especialidade) {
        List<Medico> medicos = medicoRepository.findByEspecialidade(especialidade);
        if (medicos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(medicos, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Atualiza um médico pelo ID")
    public ResponseEntity<Medico> atualizarMedico(@PathVariable String id, @RequestBody Medico medico) {
        return medicoRepository.findById(id)
                .map(m -> {
                    m.setNome(medico.getNome());
                    m.setEspecialidade(medico.getEspecialidade());
                    m.setDoencasTratadas(medico.getDoencasTratadas());
                    Medico atualizado = medicoRepository.save(m);
                    return new ResponseEntity<>(atualizado, HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deleta um médico pelo ID")
    public ResponseEntity<Void> deletarMedico(@PathVariable String id) {
        return medicoRepository.findById(id)
                .map(medico -> {
                    medicoRepository.delete(medico);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
