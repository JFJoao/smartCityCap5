package com.fiap.smartcity.service;

import com.fiap.smartcity.model.Medico;
import com.fiap.smartcity.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    private final MedicoRepository medicoRepository;

    @Autowired
    public MedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    public Medico adicionarMedico(Medico medico) {
        return medicoRepository.save(medico);
    }

    public List<Medico> listarMedicos() {
        return medicoRepository.findAll();
    }

    public Medico buscarMedicoPorId(String id) {
        return medicoRepository.findById(id).orElse(null);
    }

    public void removerMedico(String id) {
        medicoRepository.deleteById(id);
    }

    public List<Medico> buscarPorEspecialidade(String especialidade) {
        return medicoRepository.findByEspecialidade(especialidade);
    }

    public Medico atualizarMedico(String id, Medico medicoAtualizado) {
        return medicoRepository.findById(id)
                .map(medico -> {
                    medico.setNome(medicoAtualizado.getNome());
                    medico.setEspecialidade(medicoAtualizado.getEspecialidade());
                    medico.setDoencasTratadas(medicoAtualizado.getDoencasTratadas());
                    return medicoRepository.save(medico);
                })
                .orElse(null);
    }
}
