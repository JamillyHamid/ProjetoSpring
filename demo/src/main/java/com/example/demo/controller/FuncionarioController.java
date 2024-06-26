package com.example.demo.controller;

import com.example.demo.model.Funcionario;
import com.example.demo.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    FuncionarioService funcionarioService;

    @GetMapping
    public List<Funcionario> listarFuncionarios() {
        return funcionarioService.listar();
    }

    @PostMapping("/add")
    public Funcionario adicionarFuncionario(@Valid @RequestBody Funcionario funcionario) {
        return funcionarioService.adicionar(funcionario);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> atualizarFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionario) {
        if(funcionarioService.atualizar(funcionario, id) == null) {
            String mensagem = "O id informado não existe na base de dados";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        }
        return ResponseEntity.ok(funcionario);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletarFuncionario(@PathVariable Long id) {
        if(funcionarioService.deletar(id)) {
            String mensagem = "A deleção do id: " + id + " foi realizada com sucesso.";
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(mensagem);
        }
        String mensagem = "O id informado não existe na base de dados";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
    }

    @GetMapping("/listar-por-cargo/{cargo}")
    public List<Funcionario> listarFuncionariosCargo(@PathVariable String cargo){
        return funcionarioService.listarFuncionariosCargo(cargo);
    }
}
