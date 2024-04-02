package com.example.demo.controller;


import com.example.demo.model.Automoveis;
import com.example.demo.model.Cliente;
import com.example.demo.service.AutomoveisService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/automoveis")
public class AutomoveisController {

    @Autowired
    AutomoveisService automoveisService;

    @PostMapping("/add")
    public Automoveis adicionarAutomovel(@Valid @RequestBody Automoveis automoveis) {
        return automoveisService.adicionarAutomovel(automoveis);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> atualizarAutomovel(@PathVariable Long id, @RequestBody Automoveis automoveis) {
        if(automoveisService.atualizarAutomovel(id, automoveis) == null) {
            String mensagem = "O id informado não existe na base de dados";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        }
        return ResponseEntity.ok(automoveis);
    }

    @GetMapping
    public List<Automoveis> listarAutomoveis() {
        return automoveisService.listarAutomoveis();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletarAutomovel(@PathVariable Long id) {
        if(automoveisService.deletarAutomovel(id)) {
            String mensagem = "O id " + id + " foi excluído com sucesso.";
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(mensagem);
        }
        String mensagem = "O id informado não existe na base de dados";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
    }

    @GetMapping("/listar-por-preco/{preco}")
    public List<Automoveis> listarAutomoveisPreco (@PathVariable double preco){
        return automoveisService.listarAutomoveisPreco(preco);
    }

    @GetMapping("/listar-por-marca/{marca}")
    public List<Automoveis> litarAutomoveisMarca (@PathVariable String marca){
        return automoveisService.listarAutomoveisMarca(marca);
    }
}
