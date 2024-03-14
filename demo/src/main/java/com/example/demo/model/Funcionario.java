package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Funcionario extends Pessoa{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdFuncionario;
    @NotNull
    private String cargo;
    @NotNull
    @Column(nullable = false)
    @Min(value = 1)
    private double salario;
    private String vendas;


    public Funcionario() {
    }

    public Funcionario(String name, String cpf, int idade, String endereco, String celular, String cargo, double salario, String vendas) {
        super(name, cpf, idade, endereco, celular);
        this.cargo = cargo;
        this.salario = salario;
        this.vendas = vendas;
    }

    public Long getIdFuncionario() {
        return IdFuncionario;
    }

    public void setIdFuncionario(Long IdFuncionario) {
        this.IdFuncionario = IdFuncionario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getVendas() {
        return vendas;
    }

    public void setVendas(String vendas) {
        this.vendas = vendas;
    }

}
