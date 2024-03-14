package com.example.demo.service;

import com.example.demo.model.Funcionario;
import com.example.demo.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService implements PessoaService<Funcionario>{

    @Autowired
    FuncionarioRepository funcionarioRepository;

    @Override
    public List<Funcionario> listar() {
        return funcionarioRepository.findAll();
    }

    @Override
    public Funcionario adicionar(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    @Override
    public Funcionario atualizar(Funcionario funcionario, Long id) {
        //verificar se o id é valido
        if(funcionarioRepository.existsById(id)) {
            //atualizar o objeto na base
            funcionario.setIdFuncionario(id);
            return funcionarioRepository.save(funcionario);
        }
        return null;
        // não realiza nenhuma alteração
    }

    @Override
    public boolean deletar(Long id) {
        if(funcionarioRepository.existsById(id)) {
            funcionarioRepository.deleteById(id);
            return true;
        }
        return false;
    }


}
