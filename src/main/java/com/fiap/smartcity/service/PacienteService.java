package com.fiap.smartcity.service;

import com.fiap.smartcity.model.Exame;
import com.fiap.smartcity.model.Paciente;
import com.fiap.smartcity.model.Tratamento;
import com.fiap.smartcity.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public Paciente adicionarExame(String pacienteId, Exame novoExame) {
        Optional<Paciente> paciente = pacienteRepository.findById(pacienteId);
        if (paciente.isPresent()) {
            Paciente p = paciente.get();
            p.getExames().add(novoExame);
            return pacienteRepository.save(p);
        }
        throw new IllegalArgumentException("Paciente não encontrado");
    }

    public Paciente adicionarTratamento(String pacienteId, Tratamento novoTratamento) {
        Optional<Paciente> paciente = pacienteRepository.findById(pacienteId);
        if (paciente.isPresent()) {
            Paciente p = paciente.get();
            p.getTratamentos().add(novoTratamento);
            return pacienteRepository.save(p);
        }
        throw new IllegalArgumentException("Paciente não encontrado");
    }
}
