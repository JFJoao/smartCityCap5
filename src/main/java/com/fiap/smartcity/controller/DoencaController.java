package com.fiap.smartcity.controller;

import com.fiap.smartcity.model.Doenca;
import com.fiap.smartcity.repository.DoencaRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doencas")
@Api(value = "Doenças", tags = "Doenca Controller", description = "Operações relacionadas a doenças")
public class DoencaController {

    @Autowired
    private DoencaRepository doencaRepository;

    @PostMapping
    @ApiOperation(value = "Adiciona uma nova doença")
    public ResponseEntity<Doenca> adicionarDoenca(@RequestBody Doenca doenca) {
        Doenca novaDoenca = doencaRepository.save(doenca);
        return new ResponseEntity<>(novaDoenca, HttpStatus.CREATED);
    }

    @GetMapping
    @ApiOperation(value = "Lista todas as doenças")
    public ResponseEntity<List<Doenca>> listarDoencas() {
        return new ResponseEntity<>(doencaRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Busca uma doença pelo ID")
    public ResponseEntity<Doenca> buscarPorId(@PathVariable String id) {
        return doencaRepository.findById(id)
                .map(doenca -> new ResponseEntity<>(doenca, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Atualiza uma doença pelo ID")
    public ResponseEntity<Doenca> atualizarDoenca(@PathVariable String id, @RequestBody Doenca doenca) {
        return doencaRepository.findById(id)
                .map(d -> {
                    d.setNome(doenca.getNome());
                    d.setSintomas(doenca.getSintomas());
                    d.setMedicosEspecialistas(doenca.getMedicosEspecialistas());
                    Doenca atualizado = doencaRepository.save(d);
                    return new ResponseEntity<>(atualizado, HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deleta uma doença pelo ID")
    public ResponseEntity<Void> deletarDoenca(@PathVariable String id) {
        return doencaRepository.findById(id)
                .map(doenca -> {
                    doencaRepository.delete(doenca);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
