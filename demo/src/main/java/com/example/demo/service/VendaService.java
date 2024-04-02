package com.example.demo.service;

import com.example.demo.model.Automoveis;
import com.example.demo.model.Funcionario;
import com.example.demo.model.Venda;
import com.example.demo.repository.AutomoveisRepository;
import com.example.demo.repository.FuncionarioRepository;
import com.example.demo.repository.VendaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class VendaService {
    @Autowired
    VendaRepository vendaRepository;
    @Autowired
    FuncionarioRepository funcionarioRepository;
    @Autowired
    AutomoveisRepository automoveisRepository;

    public List<Venda> listar() {
        return vendaRepository.findAll();
    }

    public Venda adicionar(Venda venda) {

        return vendaRepository.save(venda);
    }

    public Venda atualizar(Venda venda, Long id) {
        if(vendaRepository.existsById(id)) {
            venda.setIdVenda(id);
            return vendaRepository.save(venda);
        }
        return null;
    }

    public boolean deletar(Long id) {
        if(vendaRepository.existsById(id)) {
            vendaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Venda> listarVendasData(LocalDate data){
        List<Venda> vendasList = vendaRepository.findAll();
        List<Venda> vendasPorData = new ArrayList<>();
        for (Venda venda : vendasList){
            if (venda.getData().isEqual(data)){
                vendasPorData.add(venda);
            }
        }
        return vendasPorData;
    }

    public List<Venda> listarVendasFuncionario(Long id){
        List<Venda> vendaList = vendaRepository.findAll();
        List<Venda> vendasPorFuncionario = new ArrayList<>();
        for (Venda venda : vendaList){
            if (venda.getIdFuncionario().equals(id)){
                vendasPorFuncionario.add(venda);
            }
        }
        return vendasPorFuncionario;
    }

    @Transactional
    public String registrarVenda(Long id){
        List<Venda> vendaList = vendaRepository.findAll();

        for(Venda venda : vendaList){
            if (venda.getIdVenda().equals(id)){
                Funcionario funcionario = funcionarioRepository.findById(venda.getIdFuncionario()).orElse(null);
                Automoveis automoveis = automoveisRepository.findById(venda.getIdAutomovel()).orElse(null);
                if (venda.getIdFuncionario().equals(funcionario.getIdFuncionario())){
                    int f = funcionario.getVendas();
                    funcionario.setVendas(f+1);
                    funcionarioRepository.save(funcionario);
                }
                if (venda.getIdAutomovel().equals(automoveis.getIdAutomovel())){
                    int a = automoveis.getQtd();
                    automoveis.setQtd(a-1);
                    automoveisRepository.save(automoveis);
                }
            }
        }
        return "Venda registrada";

    }
}
