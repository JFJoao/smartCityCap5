package steps;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

import io.cucumber.java.es.Dado;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Entao;
import io.restassured.response.Response;
import org.hamcrest.Matcher;

public class SmartCitySteps {

    private Response response;

    // Cenário: Buscar todos os usuários cadastrados
    @Dado("o sistema está conectado ao banco de dados")
    public void conectarBancoDeDados() {
        // Lógica de mock ou inicialização do banco de dados
    }

    @Quando("eu fizer uma requisição GET para {string}")
    public void fazerRequisicaoGET(String endpoint) {
        response = given().get(endpoint);
    }

    @Entao("a resposta deverá conter o status {int}")
    public void validarStatusCode(int statusCode) {
        assertEquals(statusCode, response.getStatusCode());
    }

    @Entao("o corpo deverá seguir o schema {string}")
    public void validarCorpoComSchema(String schema) {
        response.then().body(matchesJsonSchemaInClasspath("schemas/" + schema));
    }

    private Matcher<?> matchesJsonSchemaInClasspath(String s) {
        return null;
    }

    // Cenário: Cadastrar um novo usuário
    @Quando("eu enviar uma requisição POST para {string} com o corpo do novo usuário")
    public void enviarRequisicaoPost(String endpoint, io.cucumber.datatable.DataTable dataTable) {
        String nome = dataTable.cell(1, 0);
        String email = dataTable.cell(1, 1);

        String novoUsuarioJson = String.format("{ \"nome\": \"%s\", \"email\": \"%s\" }", nome, email);

        response = (Response) given();

    }
}