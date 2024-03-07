package net.javaguides.rmsbackend.service;

import net.javaguides.rmsbackend.dto.ProdutoDto;

import java.util.List;

public interface ProdutoService {
    ProdutoDto createProduto(ProdutoDto produtoDto);

    ProdutoDto getProdutoById(Long produtoId);

    List<ProdutoDto> getAllProduto();

    ProdutoDto updateProduto(Long produtoId, ProdutoDto updatedProduto);

    void deleteProduto(Long produtoId);
}
