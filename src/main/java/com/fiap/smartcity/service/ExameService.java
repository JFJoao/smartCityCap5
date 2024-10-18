package com.fiap.smartcity.service;

import com.fiap.smartcity.model.Exame;
import com.fiap.smartcity.repository.ExameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ExameService {

    @Autowired
    private ExameRepository exameRepository;

    public ExameService(ExameRepository exameRepository) {
    }

    public List<Exame> listarTodosExames() {
        return exameRepository.findAll();
    }

    public Exame buscarExamePorId(String id) {
        Optional<Exame> exame = exameRepository.findById(id);
        return exame.orElseThrow(() -> new IllegalArgumentException("Exame não encontrado"));
    }

    public Exame adicionarExame(Exame novoExame) {
        return exameRepository.save(novoExame);
    }

    public Exame atualizarExame(String id, Exame exameAtualizado) {
        Exame exameExistente = buscarExamePorId(id);
        return exameRepository.save(exameExistente);
    }

    public void removerExame(String id) {
        Exame exame = buscarExamePorId(id);
        exameRepository.delete(exame);
    }

    public List<Exame> listarExames() {
        return exameRepository.findAll();
    }
}
