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
@Document(collection = "pacientes")
public class Paciente {
    @Id
    private String id;
    private String nome;
    private int idade;
    private String genero;
    private List<String> historicoDoencas;
    private List<String> historicoMedico;

    public Paciente(String joão, String number) {
    }

    // lombok nao carregou em service, criado manual
    public List<Exame> getExames() {
        return exames;
    }

    public void setExames(List<Exame> exames) {
        this.exames = exames;
    }

    // lombok nao carregou em service, criado manual
    public List<Tratamento> getTratamentos() {
        return tratamentos;
    }

    public void setTratamentos(List<Tratamento> tratamentos) {
        this.tratamentos = tratamentos;
    }

    private List<Exame> exames;
    private List<Tratamento> tratamentos;

    public List<String> getHistoricoMedico() {
        return historicoMedico;
    }

    public void setHistoricoMedico(List<String> historicoMedico) {
        this.historicoMedico = historicoMedico;
    }
}
