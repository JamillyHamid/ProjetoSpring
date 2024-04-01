package com.example.demo.service;

import com.example.demo.model.Cliente;
import com.example.demo.model.Pessoa;
import com.example.demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements PessoaService<Cliente>{

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente adicionar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente atualizar(Cliente cliente, Long id) {
        if(clienteRepository.existsById(id)) {
            cliente.setIdCliente(id);
            return clienteRepository.save(cliente);
        }
        return null;
    }

    @Override
    public boolean deletar(Long id) {
        if(clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Cliente> listarCliente(String cpf){
        List<Cliente> clientesList = clienteRepository.findAll();
        List<Cliente> clienteList = new ArrayList<>();
        for (Cliente cliente : clientesList){
            if(cliente.getCpf().equalsIgnoreCase(cpf)){
                clienteList.add(cliente);
            }
        }
        return clienteList;
    }
}
