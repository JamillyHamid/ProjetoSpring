package com.example.demo.service;

import com.example.demo.model.Automoveis;
import com.example.demo.repository.AutomoveisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutomoveisService {

    @Autowired
    AutomoveisRepository automoveisRepository;

    public List<Automoveis> listarAutomoveis() {
        return automoveisRepository.findAll();
    }

    public Automoveis adicionarAutomovel(Automoveis automoveis) {
        return automoveisRepository.save(automoveis);
    }

    public Automoveis atualizarAutomovel(Long Id, Automoveis automoveis) {
        if(automoveisRepository.existsById(Id)) {
            automoveis.setIdAutomovel(Id);
            return automoveisRepository.save(automoveis);
        }
        return null;
    }

    public boolean deletarAutomovel(Long id) {
        if(automoveisRepository.existsById(id)) {
            automoveisRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public int qtdAutomoveis () {
        return automoveisRepository.findAll().size();
    }

     public List<Automoveis> listarAutomoveisPreco (double preco){
        List<Automoveis> automoveisList = automoveisRepository.findAll();
        List <Automoveis> automoveisPorPreco = new ArrayList<>();
        for (Automoveis automoveis : automoveisList){
            if (automoveis.getPreco() < preco){
                automoveisPorPreco.add(automoveis);
            }
        }
        return automoveisPorPreco;
    }

    public List<Automoveis> listarAutomoveisMarca (String marca){
        List<Automoveis> automoveisList = automoveisRepository.findAll();
        List <Automoveis> automoveisPorMarca = new ArrayList<>();
        for (Automoveis automoveis : automoveisList){
            if (automoveis.getMarca().equalsIgnoreCase(marca)){
                automoveisPorMarca.add(automoveis);
            }
        }
        return automoveisPorMarca;
    }
    
}
