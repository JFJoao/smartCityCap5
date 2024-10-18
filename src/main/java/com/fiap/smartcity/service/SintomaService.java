package com.fiap.smartcity.service;

import com.fiap.smartcity.model.Sintoma;
import com.fiap.smartcity.repository.SintomaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SintomaService {

    @Autowired
    private SintomaRepository sintomaRepository;

    public Sintoma adicionarSintoma(Sintoma sintoma) {
        return sintomaRepository.save(sintoma);
    }

    public List<Sintoma> listarSintomas() {
        return sintomaRepository.findAll();
    }

    public Optional<Sintoma> buscarPorId(String id) {
        return sintomaRepository.findById(id);
    }

    public Sintoma atualizarSintoma(String id, Sintoma sintomaAtualizado) {
        return sintomaRepository.findById(id)
                .map(s -> {
                    s.setNome(sintomaAtualizado.getNome());
                    s.setDescricao(sintomaAtualizado.getDescricao());
                    s.setDoencasAssociadas(sintomaAtualizado.getDoencasAssociadas());
                    return sintomaRepository.save(s);
                })
                .orElse(null);
    }

    public void deletarSintoma(String id) {
        sintomaRepository.findById(id)
                .ifPresent(sintomaRepository::delete);
    }
}
