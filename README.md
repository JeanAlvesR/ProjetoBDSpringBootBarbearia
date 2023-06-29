# Backend da Barbearia em Spring Boot com API REST

Este é o repositório do backend da aplicação de uma barbearia desenvolvida em Spring Boot, utilizando API REST. 

## Tecnologias utilizadas

- Java
- Spring Boot
- Maven
- JPA e Hibernate

## Estrutura do projeto

O projeto está dividido em camadas para melhor organização e separação de responsabilidades. As camadas são:

1. **Controller**: Responsável por receber as requisições REST e encaminhá-las para os respectivos serviços.
2. **Service**: Contém a lógica de negócio da aplicação e realiza a comunicação com o repositório.
3. **Repository**: Responsável pela interação com o banco de dados, utilizando JPA e Hibernate.

## Funcionalidades implementadas

- API REST para gerenciamento da barbearia.
- Utilização de enums para os tipos de usuário (Role) e status.
- Scheduler para verificação de agendamentos e mudança de status de "andamento" para "concluído".
- Tratamento de exceções personalizadas utilizando RestControllerAdvice.
- Testes no Postman para validar as funcionalidades da API.

## Próximas melhorias

Devido à falta de tempo, algumas funcionalidades não foram implementadas no momento. As próximas melhorias planejadas são:

- Adicionar autenticação nas rotas da API para garantir a segurança.
- Implementar DTO (Data Transfer Object) para melhorar a estrutura e segurança das informações transmitidas pela API.
- Substituir o banco de dados H2-console por PostgreSQL para um ambiente de produção mais robusto.
- Testes Unitários e de Integração

## Como executar o projeto

1. Certifique-se de ter o Java (19 ou superior) e o Maven instalados em sua máquina.
2. Clone este repositório para sua máquina local.

## Contato

Se tiver alguma dúvida ou sugestão, por favor, entre em contato conosco:

Nome: Jean Alves Rocha
Email: EngJeanR@gmail.com


## Configuração do Banco de Dados

O banco de dados utilizado é o PostgreSQL. Certifique-se de ter o PostgreSQL instalado e configurado em seu ambiente de desenvolvimento antes de prosseguir.

1. Crie um novo banco de dados no PostgreSQL para a aplicação da barbearia.

2. Abra o arquivo `application.properties` localizado na pasta `src/main/resources` do projeto.

3. No arquivo `application.properties`, atualize as seguintes propriedades para refletir a configuração do seu banco de dados:

```properties
server.port=8081
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
```

## Tabelas e Triggers

O banco de dados contém as seguintes tabelas relacionadas à barbearia:

1. Tabela "usuario": Armazena informações dos usuários do sistema.

2. Tabela "cliente": Mantém os dados dos clientes da barbearia.

3. Tabela "barbeiro": Registra os detalhes dos barbeiros disponíveis.

4. Tabela "agendamento": Armazena os agendamentos de cortes de cabelo, incluindo informações sobre o cliente, o barbeiro, a data e o status do agendamento.

5. Tabela "comentarios": Guarda os comentários dos clientes sobre a barbearia.

Além disso, foram implementadas duas triggers (Por enquanto) no banco de dados:

1. Trigger "tr_verificar_horario_agendamento": Impede o agendamento de um corte de cabelo dentro de um período de 40 minutos de um agendamento já existente com status "andamento".
2. Trigger "tr_atualiza_qtd_agendamento": Toda vez que um agendamento é feito, ele verifica a quantidade de agendamentos feitos e, se chegar a 10, a pessoa ganha uma promocao e os agendamentos zeram, se não chegar, aumenta mais 1 nos agendamentos.
3 - Função para cancelar agendamento.

## Licença

Este projeto está licenciado sob a licença [MIT](LICENSE).

---
