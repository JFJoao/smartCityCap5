package com.fiap.smartcity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "medicos")
public class Medico {
    @Id
    private String id;
    private String nome;
    private String especialidade;
    private List<String> doencasTratadas;

    public Medico(String s, String crm123) {
    }
}
