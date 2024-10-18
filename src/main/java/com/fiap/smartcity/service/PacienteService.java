package com.fiap.smartcity.service;

import com.fiap.smartcity.model.Exame;
import com.fiap.smartcity.model.Paciente;
import com.fiap.smartcity.model.Tratamento;
import com.fiap.smartcity.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
    }

    // Método para adicionar um novo paciente
    public Paciente adicionarPaciente(Paciente novoPaciente) {
        return pacienteRepository.save(novoPaciente);
    }

    // Método para adicionar um novo exame a um paciente
    public Paciente adicionarExame(String pacienteId, Exame novoExame) {
        Optional<Paciente> paciente = pacienteRepository.findById(pacienteId);
        if (paciente.isPresent()) {
            Paciente p = paciente.get();
            p.getExames().add(novoExame);
            return pacienteRepository.save(p);
        }
        throw new IllegalArgumentException("Paciente não encontrado");
    }

    // Método para adicionar um novo tratamento a um paciente
    public Paciente adicionarTratamento(String pacienteId, Tratamento novoTratamento) {
        Optional<Paciente> paciente = pacienteRepository.findById(pacienteId);
        if (paciente.isPresent()) {
            Paciente p = paciente.get();
            p.getTratamentos().add(novoTratamento);
            return pacienteRepository.save(p);
        }
        throw new IllegalArgumentException("Paciente não encontrado");
    }

    // Método para listar todos os pacientes
    public List<Paciente> listarPacientes() {
        return pacienteRepository.findAll();
    }

    // Método para buscar um paciente pelo ID
    public Paciente buscarPorId(String id) {
        return pacienteRepository.findById(id).orElse(null);
    }

    // Método para atualizar os dados de um paciente
    public Paciente atualizarPaciente(String id, Paciente pacienteAtualizado) {
        Optional<Paciente> pacienteOptional = pacienteRepository.findById(id);
        if (pacienteOptional.isPresent()) {
            Paciente pacienteExistente = pacienteOptional.get();
            pacienteExistente.setNome(pacienteAtualizado.getNome());
            pacienteExistente.setIdade(pacienteAtualizado.getIdade());
            pacienteExistente.setHistoricoMedico(pacienteAtualizado.getHistoricoMedico());
            pacienteExistente.setExames(pacienteAtualizado.getExames());
            pacienteExistente.setTratamentos(pacienteAtualizado.getTratamentos());
            return pacienteRepository.save(pacienteExistente);
        }
        return null;
    }

    // Método para remover um paciente
    public void removerPaciente(String id) {
        pacienteRepository.deleteById(id);
    }
}
