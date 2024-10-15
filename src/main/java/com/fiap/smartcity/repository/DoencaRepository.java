package com.fiap.smartcity.repository;

import com.fiap.smartcity.model.Doenca;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoencaRepository extends MongoRepository<Doenca, String> {

    // encontrar doenças por lista de sintomas
    List<Doenca> findBySintomasIn(List<String> sintomas);
}
