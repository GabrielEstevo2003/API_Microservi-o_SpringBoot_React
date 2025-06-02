package com.example.CatalogoProdutos.Controllers;

import com.example.CatalogoProdutos.Models.Racao;
import com.example.CatalogoProdutos.Services.RacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("API-Microservico/racao")
@CrossOrigin(origins = "*")
@Tag(name = "Rações", description = "Gerenciamento de Produtos(Rações)")
public class RacaoController {
    @Autowired
    private RacaoService racaoService;

    @Operation(
            summary = "Cria um produto(Ração)",
            description = "Retorna um objeto de Ração"
    )
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
    @Operation(
            summary = "Lista de Rações",
            description = "Retorna uma lista de Rações"
    )
    @GetMapping
    public ResponseEntity<List<Racao>> findAll(){
        return ResponseEntity.ok(racaoService.findAll());
    }
    @Operation(
            summary = "Lista uma ração em específico por ID",
            description = "Retorna uma ração com o ID especificado"
    )
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Racao>> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(racaoService.findById(id));
    }

    @Operation(
            summary = "Deleta um produto(Ração)",
            description = "Deleta um produto(Ração)"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id){
        racaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
