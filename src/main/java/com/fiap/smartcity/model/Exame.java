package com.fiap.smartcity.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Exame {

    @Getter
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    private String tipo;
    private String imagem; //url
    private String laudo;

    public Exame(String sangue, String exameDeSangue) {
    }

    public String getNome() {
        return tipo;
    }

    public void setNome(String sangueTotal) {
    }


}
