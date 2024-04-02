package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.UniqueElements;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Automoveis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdAutomovel;
    @NotNull
    private String marca;
    @NotNull
    private String modelo;
    @NotNull
    private String tipoCambio;
    @NotNull
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

    public Automoveis(String marca, String modelo,String tipoCambio, String cor, double preco, String combustivel, int ano, int qtd) {
        this.marca = marca;
        this.modelo = modelo;
        this.tipoCambio = tipoCambio;
        this.cor = cor;
        this.preco = preco;
        this.combustivel = combustivel;
        this.ano = ano;
        this.qtd = qtd;
    }

    public Long getIdAutomovel() {
        return IdAutomovel;
    }

    public void setIdAutomovel(Long idAutomovel) {
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

    public String getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(String tipoCambio) {
        this.tipoCambio = tipoCambio;
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
