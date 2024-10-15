package com.fiap.smartcity.repository;

import com.fiap.smartcity.model.Tratamento;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TratamentoRepository extends MongoRepository<Tratamento, String> {


}
