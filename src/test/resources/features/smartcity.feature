Funcionalidade: Testes da API de usuários

Cenário: Buscar todos os usuários cadastrados
    Dado que o sistema está conectado ao banco de dados
    Quando eu fizer uma requisição GET para "/users"
    Então a resposta deverá conter o status 200
    E o corpo deverá seguir o schema "users-schema.json"

Cenário: Cadastrar um novo usuário
    Dado que o sistema está pronto para aceitar novas requisições
    E eu tenho um JSON válido com os dados do novo usuário
    Quando eu enviar uma requisição POST para "/users" com o corpo do novo usuário
    Então a resposta deverá conter o status 201
    E o corpo da resposta deverá conter o nome "João"
    E o corpo da resposta deverá conter o email "joao@example.com"

Cenário: Tentar cadastrar um usuário com dados inválidos
    Dado que o sistema está pronto para aceitar novas requisições
    E eu tenho um JSON inválido com dados incompletos
    Quando eu enviar uma requisição POST para "/users" com o corpo inválido
    Então a resposta deverá conter o status 400
    E o corpo da resposta deverá conter a mensagem de erro "Dados inválidos"

