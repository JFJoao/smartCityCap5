package com.fiap.smartcity.repository;

import com.fiap.smartcity.model.Sintoma;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SintomaRepository extends MongoRepository<Sintoma, String> {
    List<Sintoma> findByDescricaoContainingIgnoreCase(String descricao);
}
