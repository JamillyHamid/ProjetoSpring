package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Cliente extends Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long IdCliente;
    @NotNull
    @Size(min = 11, max = 12)
    private String cnh;
    private String email;

    public Cliente() {
    }

    public Cliente(String name, String cpf, int idade, String endereco, String celular, String cnh, String email) {
        super(name, cpf, idade, endereco, celular);
        this.cnh = cnh;
        this.email = email;

    }

    public long getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(long idCliente) {
        IdCliente = idCliente;
    }


    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
