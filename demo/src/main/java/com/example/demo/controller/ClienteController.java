package com.example.demo.controller;

import com.example.demo.model.Cliente;
import com.example.demo.model.Funcionario;
import com.example.demo.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @PostMapping
    public Cliente adicionarCliente(@Valid @RequestBody Cliente cliente) {
        return clienteService.adicionar(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        //return funcionarioService.atualizar(id, funcionario);
        if(clienteService.atualizar(cliente, id) == null) {
            String mensagem = "O id informado não existe na base de dados";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
            //return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente);
    }

    @GetMapping
    public List<Cliente> listarCliente() {
        return clienteService.listar();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarCliente(@PathVariable Long id) {
        if(clienteService.deletar(id)) {
            String mensagem = "O id " + id + " foi excluído com sucesso.";
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(mensagem);
        }
        String mensagem = "O id informado não existe na base de dados";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
    }

    @GetMapping("/{cpf}")
    public List<Cliente> listarCliente(@PathVariable String cpf){
        return clienteService.listarCliente(cpf);
    }
}
