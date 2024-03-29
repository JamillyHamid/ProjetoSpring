package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Automoveis {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long IdAutomovel;
    @NotNull
    private String marca;
    @NotNull
    private String modelo;
    private String cor;
    @NotNull
    @Column(nullable = false)
    @Min(value = 1)
    private double preco;
    @NotNull
    private String combustivel;
    @NotNull
    private int ano;
    @NotNull
    private int qtd;

    public Automoveis() {
    }

    public Automoveis(long idAutomovel, String marca, String modelo, String cor, double preco, String combustivel, int ano, int qtd) {
        IdAutomovel = idAutomovel;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.preco = preco;
        this.combustivel = combustivel;
        this.ano = ano;
        this.qtd = qtd;
    }

    public long getIdAutomovel() {
        return IdAutomovel;
    }

    public void setIdAutomovel(long idAutomovel) {
        IdAutomovel = idAutomovel;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
}
