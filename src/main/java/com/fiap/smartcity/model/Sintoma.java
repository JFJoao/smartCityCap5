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
@Document(collection = "sintomas")
public class Sintoma {
    @Id
    private String id;
    private String nome;
    private String descricao;
    private List<String> doencasAssociadas;

}
