package com.example.demo.controller;

import com.example.demo.model.Funcionario;
import com.example.demo.model.Venda;
import com.example.demo.repository.VendaRepository;
import com.example.demo.service.VendaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    VendaService vendaService;

    @GetMapping
    public List<Venda> listarVenda() {
        return vendaService.listar();
    }

    @PostMapping("/add")
    public Venda adicionarVenda(@Valid @RequestBody Venda venda) {
        return vendaService.adicionar(venda);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> atualizarVenda(@PathVariable Long id, @RequestBody Venda venda) {
        if(vendaService.atualizar(venda, id) == null) {
            String mensagem = "O id informado não existe na base de dados";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        }
        return ResponseEntity.ok(venda);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletarVenda(@PathVariable Long id) {
        if(vendaService.deletar(id)) {
            String mensagem = "A deleção do id: " + id + " foi realizada com sucesso.";
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(mensagem);
        }
        String mensagem = "O id informado não existe na base de dados";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
    }

    @GetMapping("/{data}")
    public List<Venda> listarVendasPorData(@PathVariable LocalDate data){
        return vendaService.listarVendasData(data);
    }

    @GetMapping("/{id}")
    public List<Venda> listarVendasPorFuncionario(@PathVariable Long id){
        return vendaService.listarVendasFuncionario(id);
    }

    @PutMapping("/registrar/{id}")
    public String registrarVenda(@PathVariable Long id){
        return vendaService.registrarVenda(id);
    }

}
