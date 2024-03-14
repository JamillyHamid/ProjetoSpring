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
        //verificar se o id é valido
        if(automoveisRepository.existsById(Id)) {
            //atualizar o objeto na base
            automoveis.setIdAutomovel(Id);
            return automoveisRepository.save(automoveis);
        }
        return null;
        // não realiza nenhuma alteração
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
}
