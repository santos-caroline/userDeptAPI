package com.santos_caroline.userDept.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @Entity: Define que esta classe é uma entidade gerenciada pelo JPA (Jakarta Persistence API).
 * - O que ela faz? Diz ao framework que cada instância desta classe representa uma linha na tabela do banco de dados.
 * - ORM (Object-Relational Mapping): É a ponte que permite "mapear" o mundo dos Objetos (Java) para o mundo
 * Relacional (SQL). Sem isso, você teria que escrever SQL manualmente para cada inserção ou busca.
 * - JPA vs Hibernate: O JPA é a especificação (o manual de regras), enquanto o Hibernate é a implementação (quem
 * realmente faz o trabalho pesado por trás dos panos). Dê preferencia pra especificação assim o projeto fica genérico
 * e permite mudanças de especificações.

  * @GeneratedValue: Define a estratégia de geração de valores para a Chave Primária (@Id).
 * * - Por que usar? Evita que você tenha que definir manualmente o ID (ex: id = 1, id = 2) toda vez que salvar um
 * novo objeto. O framework e o banco fazem isso por você.
 *
 * * - strategy = GenerationType.IDENTITY: É o modo "Auto-Increment". O Hibernate envia o comando de INSERT sem o ID,
 * e o Banco de Dados (MySQL, Postgres, H2) gera o próximo número da sequência.
 * * - Benefício: Garante a integridade dos dados e evita conflitos de IDs duplicados em sistemas com muitos acessos
 * simultâneos.
 */

@Entity
@Table(name = "tb_department") //nome da minha tabela de entidade departamento
public class Department {

    @Id //PK (chave primária)
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;

    public Department() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
//21:40