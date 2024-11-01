package com.fiap.smartcity.services;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Então;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;
import org.hamcrest.Matcher;

public class ApiTeste {

    private Response response;

    // Cenário: Buscar todos os usuários cadastrados
    @Dado("que o sistema está conectado ao banco de dados")
    public void conectarBancoDeDados() {
        // Lógica para inicializar conexão ou mock do banco de dados
    }

    @Quando("eu fizer uma requisição GET para {string}")
    public void fazerRequisicaoGET(String endpoint) {
        response = given().get(endpoint);
    }

    @Então("o status da resposta deverá ser {int}")
    public void validarStatusCode(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @Então("o corpo da resposta deverá seguir o schema {string}")
    public void validarCorpoComSchema(String schema) {
        response.then().body(matchesJsonSchemaInClasspath("schemas/" + schema));
    }

    private Matcher<?> matchesJsonSchemaInClasspath(String s) {
        return null;
    }

    // Cenário: Cadastrar um novo usuário
    @Quando("eu enviar uma requisição POST para {string} com o nome {string} e email {string}")
    public void enviarRequisicaoPOST(String endpoint, String nome, String email) {
        String novoUsuarioJson = String.format("{ \"nome\": \"%s\", \"email\": \"%s\" }", nome, email);

        response = given()
                .contentType("application/json")
                .body(novoUsuarioJson)
                .when().post(endpoint);
    }

    @Então("o corpo da resposta deverá conter o nome {string}")
    public void validarNomeNaResposta(String nome) {
        response.then().body("nome", equalTo(nome));
    }

    @Então("o corpo da resposta deverá conter o email {string}")
    public void validarEmailNaResposta(String email) {
        response.then().body("email", equalTo(email));
    }

    // Cenário: Tentar cadastrar um usuário com dados inválidos
    @Quando("eu enviar uma requisição POST para {string} com dados inválidos")
    public void enviarRequisicaoPostInvalida(String endpoint) {
        String usuarioInvalidoJson = "{ \"nome\": \"\", \"email\": \"invalido\" }";

        response = given()
                .contentType("application/json")
                .body(usuarioInvalidoJson)
                .when().post(endpoint);
    }

    @Então("o status da resposta deverá ser {int} e o corpo deverá conter a mensagem de erro {string}")
    public void validarMensagemDeErro(int statusCode, String mensagemErro) {
        response.then().statusCode(statusCode).body("error", equalTo(mensagemErro));
    }
}
