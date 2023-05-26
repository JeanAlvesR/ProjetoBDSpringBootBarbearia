(README em andamento...)
Este é um projeto Spring Boot para uma aplicação de gerenciamento de uma barbearia. A aplicação utiliza o banco de dados PostgreSQL para armazenar os dados relacionados aos usuários, clientes, barbeiros, agendamentos e comentários.

## Configuração do Banco de Dados

O banco de dados utilizado é o PostgreSQL. Certifique-se de ter o PostgreSQL instalado e configurado em seu ambiente de desenvolvimento antes de prosseguir.

1. Crie um novo banco de dados no PostgreSQL para a aplicação da barbearia.

2. Abra o arquivo `application.properties` localizado na pasta `src/main/resources` do projeto.

3. No arquivo `application.properties`, atualize as seguintes propriedades para refletir a configuração do seu banco de dados:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/Barbearia
spring.datasource.username=postgres
spring.datasource.password=1234
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

## Licença

Este projeto está licenciado sob a licença [MIT](LICENSE).

---
