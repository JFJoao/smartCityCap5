# FIAP Simple API - Smart City

## Descrição do Projeto

O **FIAP Simple API - Smart City** é uma API desenvolvida em Java utilizando Spring Boot, MongoDB, e Docker para fornecer uma plataforma simples de gerenciamento de dados para uma aplicação de cidade inteligente (Smart City). A API permite o gerenciamento de informações de pacientes, médicos, tratamentos e exames, oferecendo uma base para a integração com outros serviços ou interfaces de uma cidade inteligente. Este projeto foi desenvolvido como parte de uma solução moderna para facilitar o acesso a dados médicos em ambientes urbanos inteligentes.

## Funcionalidades

- CRUD de Pacientes
- CRUD de Médicos
- Filtros de busca por sintomas para encontrar médicos
- Integração com banco de dados MongoDB
- Deploy em um ambiente Azure com containers Docker

## Tecnologias Utilizadas

- **Java 17**: Linguagem de programação principal
- **Spring Boot**: Framework para facilitar o desenvolvimento da API
- **MongoDB**: Banco de dados NoSQL para armazenar os dados da aplicação
- **Docker**: Para conteinerização da aplicação
- **Azure App Service**: Hospedagem da aplicação no Azure com containers

## Pré-requisitos

Antes de iniciar, você precisará ter instalado em sua máquina:

- **Java 21** (JDK)
- **Maven** (para gerenciamento de dependências)
- **Docker** (para construir e executar a imagem da aplicação)
- **MongoDB** (instância local ou em nuvem)

## Como inicializar e executar o projeto

### Passo 1: Clonar o repositório

Clone o repositório do projeto em sua máquina local.

```bash
git clone https://github.com/jfjoaodev/fiap-simple-api-smartcity.git
cd fiap-simple-api-smartcity
```

## Passo 2: Configurar o MongoDB

Configure uma instância do MongoDB local ou em nuvem. Se estiver usando o MongoDB local, certifique-se de que ele está rodando na porta padrão **27017**.

Altere as variáveis de ambiente do MongoDB no arquivo `application.properties` ou configure-as via ambiente (por exemplo, usando Docker Compose).

## Passo 3: Construir e executar a aplicação

### Com Docker:

Certifique-se de que o **Docker** está instalado e em execução na sua máquina. Execute o comando para construir e rodar o container Docker:

```bash
docker build -t fiap-simple-api-smartcity .
docker run -p 8080:8080 fiap-simple-api-smartcity
```

### Sem Docker (localmente com Maven):
Se você preferir rodar o projeto localmente sem Docker, utilize o Maven para compilar e iniciar o projeto:

```bash
mvn clean install
mvn spring-boot:run
```

## Passo 4: Acessar a aplicação
Após inicializar o projeto, a aplicação estará disponível na porta 8080. Você pode acessar o Swagger UI para visualizar e testar as APIs disponíveis:

```bash
http://localhost:8080/swagger-ui.html
```
Se você tiver feito o deploy no Azure, substitua localhost:8080 pelo URL do serviço hospedado.

## Variáveis de Ambiente
Certifique-se de configurar as seguintes variáveis de ambiente para a aplicação:

- MONGODB_HOST: URL da instância do MongoDB
- MONGODB_PORT: Porta do MongoDB (padrão: 27017)
- MONGODB_USER: Usuário do MongoDB
- MONGODB_PASSWORD: Senha do MongoDB
- DOCKER_REGISTRY_SERVER_URL: URL do registro Docker (ex: https://index.docker.io)
- DOCKER_REGISTRY_SERVER_USERNAME: Usuário do Docker Hub
- DOCKER_REGISTRY_SERVER_PASSWORD: Senha ou token de acesso do Docker Hub
