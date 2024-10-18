package com.fiap.smartcity.service;

import com.fiap.smartcity.model.Doenca;
import com.fiap.smartcity.repository.DoencaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoencaService {

    @Autowired
    private DoencaRepository doencaRepository;

    public Doenca salvar(Doenca doenca) {
        return doencaRepository.save(doenca);
    }
}