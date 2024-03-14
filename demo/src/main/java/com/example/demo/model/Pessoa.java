package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@MappedSuperclass
public abstract class Pessoa {

    @NotNull
    private String name;
    @NotNull(message = "Campo cpf não pode ser nulo.")
    @Column(nullable = false)
    @Size(min = 11, max = 14)
    private String cpf;
    private int idade;
    private String endereco;
    @Size(min = 11, max = 15)
    private String celular;

    public Pessoa() {
    }

    public Pessoa(String name, String cpf, int idade, String endereco, String celular) {
        this.name = name;
        this.cpf = cpf;
        this.idade = idade;
        this.endereco = endereco;
        this.celular = celular;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
}
