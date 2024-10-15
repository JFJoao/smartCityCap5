package com.fiap.smartcity.repository;

import com.fiap.smartcity.model.Exame;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExameRepository extends MongoRepository<Exame, String> {


}
