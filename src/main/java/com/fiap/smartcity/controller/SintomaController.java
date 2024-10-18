package com.fiap.smartcity.controller;

import com.fiap.smartcity.model.Sintoma;
import com.fiap.smartcity.repository.SintomaRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sintomas")
@Api(value = "Sintomas", tags = "Sintoma Controller", description = "Operações relacionadas a sintomas")
public class SintomaController {

    @Autowired
    private SintomaRepository sintomaRepository;

    @PostMapping
    @ApiOperation(value = "Adiciona um novo sintoma")
    public ResponseEntity<Sintoma> adicionarSintoma(@RequestBody Sintoma sintoma) {
        Sintoma novoSintoma = sintomaRepository.save(sintoma);
        return new ResponseEntity<>(novoSintoma, HttpStatus.CREATED);
    }

    @GetMapping
    @ApiOperation(value = "Lista todos os sintomas")
    public ResponseEntity<List<Sintoma>> listarSintomas() {
        return new ResponseEntity<>(sintomaRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Busca um sintoma pelo ID")
    public ResponseEntity<Sintoma> buscarPorId(@PathVariable String id) {
        return sintomaRepository.findById(id)
                .map(sintoma -> new ResponseEntity<>(sintoma, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Atualiza um sintoma pelo ID")
    public ResponseEntity<Sintoma> atualizarSintoma(@PathVariable String id, @RequestBody Sintoma sintoma) {
        return sintomaRepository.findById(id)
                .map(s -> {
                    s.setNome(sintoma.getNome());
                    s.setDescricao(sintoma.getDescricao());
                    s.setDoencasAssociadas(sintoma.getDoencasAssociadas());
                    Sintoma atualizado = sintomaRepository.save(s);
                    return new ResponseEntity<>(atualizado, HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deleta um sintoma pelo ID")
    public ResponseEntity<Void> deletarSintoma(@PathVariable String id) {
        return sintomaRepository.findById(id)
                .map(sintoma -> {
                    sintomaRepository.delete(sintoma);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
