package com.fiap.smartcity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Exame {
    private String tipo;
    private String imagem; //url
    private String laudo;
}
