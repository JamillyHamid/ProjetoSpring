package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVenda;
    @NotNull
    private Long idFuncionario;
    @NotNull
    private Long idCliente;
    @NotNull
    private Long idAutomovel;
    @NotNull
    private LocalDate data = LocalDate.now();
    @NotNull
    private double preco;

    public Venda() {
    }

    public Venda(Long idFuncionario, Long idCliente, Long idAutomovel, LocalDate data, double preco) {
        this.idFuncionario = idFuncionario;
        this.idCliente = idCliente;
        this.idAutomovel = idAutomovel;
        this.data = data;
        this.preco = preco;
    }

    public Long getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Long idVenda) {
        this.idVenda = idVenda;
    }

    public Long getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Long idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdAutomovel() {
        return idAutomovel;
    }

    public void setIdAutomovel(Long idAutomovel) {
        this.idAutomovel = idAutomovel;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
