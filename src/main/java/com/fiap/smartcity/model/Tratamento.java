package com.fiap.smartcity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tratamento {
    private String medicamento;
    private String dosagem;
    private String duracao;
}
