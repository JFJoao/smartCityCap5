package com.fiap.smartcity.service;

import com.fiap.smartcity.model.Tratamento;
import com.fiap.smartcity.repository.TratamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TratamentoService {

    @Autowired
    private TratamentoRepository tratamentoRepository;

    public List<Tratamento> listarTodosTratamentos() {
        return tratamentoRepository.findAll();
    }

    public Tratamento buscarTratamentoPorId(String id) {
        Optional<Tratamento> tratamento = tratamentoRepository.findById(id);
        return tratamento.orElseThrow(() -> new IllegalArgumentException("Tratamento não encontrado"));
    }

    public Tratamento adicionarTratamento(Tratamento novoTratamento) {
        return tratamentoRepository.save(novoTratamento);
    }

    public Tratamento atualizarTratamento(String id, Tratamento tratamentoAtualizado) {
        Tratamento tratamentoExistente = buscarTratamentoPorId(id);
        tratamentoExistente.setDuracao(tratamentoAtualizado.getDuracao());
        return tratamentoRepository.save(tratamentoExistente);
    }

    public void removerTratamento(String id) {
        Tratamento tratamento = buscarTratamentoPorId(id);
        tratamentoRepository.delete(tratamento);
    }
}
