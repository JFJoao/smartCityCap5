package com.fiap.smartcity.repository;

import com.fiap.smartcity.model.Medico;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicoRepository extends MongoRepository<Medico, String> {
    List<Medico> findByEspecialidade(String especialidade);
}
