package com.santos_caroline.userDept.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/*
* @JoinColumn: Usada para Objetos/Entidades. Mapeia uma conexão entre tabelas.
 */

@Entity
@Table(name = "tb_user")
public class User {

    @Id //PK (chave primária)
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private String email;

    @ManyToOne //muitos (N) usuários para 1 departamento
    @JoinColumn(name = "department_id") // Nome da coluna FK (chave estrangeira) no banco
    private Department department; //associação entre entidades (relacionamento)

    public User() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
