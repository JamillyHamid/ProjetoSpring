package com.example.demo.service;

import com.example.demo.model.Automoveis;
import com.example.demo.model.Cliente;
import com.example.demo.model.Funcionario;
import com.example.demo.model.Venda;
import com.example.demo.repository.FuncionarioRepository;
import com.example.demo.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        if(funcionarioRepository.existsById(id)) {
            funcionario.setIdFuncionario(id);
            return funcionarioRepository.save(funcionario);
        }
        return null;
    }

    @Override
    public boolean deletar(Long id) {
        if(funcionarioRepository.existsById(id)) {
            funcionarioRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Funcionario> listarFuncionariosCargo(String cargo){
        List<Funcionario> funcionariosList = funcionarioRepository.findAll();
        List<Funcionario> funcionarioPorCargo = new ArrayList<>();
        for (Funcionario funcionario : funcionariosList){
            if (funcionario.getCargo().equals(cargo)){
                funcionarioPorCargo.add(funcionario);
            }
        }
        return funcionarioPorCargo;
    }
}
