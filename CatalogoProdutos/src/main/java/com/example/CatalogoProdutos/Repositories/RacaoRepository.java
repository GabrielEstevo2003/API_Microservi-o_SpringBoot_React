package com.example.CatalogoProdutos.Repositories;

import com.example.CatalogoProdutos.Models.Racao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RacaoRepository extends JpaRepository<Racao, Long> {
}
