package com.example.CatalogoProdutos.Services;

import com.example.CatalogoProdutos.Models.Racao;
import com.example.CatalogoProdutos.Repositories.RacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RacaoService {
    @Autowired
    private RacaoRepository racaoRepository;

    public Racao insert(Racao racao){
        return racaoRepository.save(racao);
    }

    public List<Racao> findAll(){
        return racaoRepository.findAll();
    }

    public Optional<Racao> findById(Long id){
        return racaoRepository.findById(id);
    }

    public void deleteById(Long id){
        racaoRepository.deleteById(id);
    }
}
