package com.example.CatalogoProdutos.Controllers;

import com.example.CatalogoProdutos.Models.Racao;
import com.example.CatalogoProdutos.Services.RacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("API-Microservico/racao")
@CrossOrigin(origins = "*")
public class RacaoController {
    @Autowired
    private RacaoService racaoService;

    @PostMapping
    public ResponseEntity<Racao> insert(@RequestBody Racao racao){
        Racao novo = racaoService.insert(racao);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }

    @PutMapping
    public ResponseEntity<Racao> update(@RequestBody Racao racao){
        Racao savedRacao = racaoService.insert(racao);
        return ResponseEntity.ok(savedRacao);
    }

    @GetMapping
    public ResponseEntity<List<Racao>> findAll(){
        return ResponseEntity.ok(racaoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Racao>> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(racaoService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id){
        racaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
