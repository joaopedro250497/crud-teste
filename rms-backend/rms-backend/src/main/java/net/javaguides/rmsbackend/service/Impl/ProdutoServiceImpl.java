package net.javaguides.rmsbackend.service.Impl;

import lombok.AllArgsConstructor;
import net.javaguides.rmsbackend.dto.ProdutoDto;
import net.javaguides.rmsbackend.entity.Produto;
import net.javaguides.rmsbackend.exception.ResourceNotFoundException;
import net.javaguides.rmsbackend.mapper.ProdutoMapper;
import net.javaguides.rmsbackend.repository.ProdutoRepository;
import net.javaguides.rmsbackend.service.ProdutoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {

    private ProdutoRepository produtoRepository;

    @Override
    public ProdutoDto createProduto(ProdutoDto produtoDto) {

        Produto produto = ProdutoMapper.mapToProduto(produtoDto);
        Produto savedProduto = produtoRepository.save(produto);
        return ProdutoMapper.mapToProdutoDto(savedProduto);
    }

    @Override
    public ProdutoDto getProdutoById(Long produtoId) {
        Produto produto = produtoRepository.findById(produtoId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Produto inexistente pelo ID fornecido: " + produtoId));
        return ProdutoMapper.mapToProdutoDto(produto);
    }

    @Override
    public List<ProdutoDto> getAllProduto() {
        List<Produto> produtos = produtoRepository.findAll();
        return produtos.stream().map((produto) -> ProdutoMapper.mapToProdutoDto(produto))
                .collect(Collectors.toList());
    }

    @Override
    public ProdutoDto updateProduto(Long produtoId, ProdutoDto updatedProduto) {

        Produto produto = produtoRepository.findById(produtoId).orElseThrow(
                () -> new ResourceNotFoundException("Produto inexistente pelo ID fornecido: " + produtoId)
        );


        produto.setDescricao(updatedProduto.getDescricao());

        Produto updatedProdutoObj = produtoRepository.save(produto);

        return ProdutoMapper.mapToProdutoDto(updatedProdutoObj);
    }

    @Override
    public void deleteProduto(Long produtoId) {

        Produto produto = produtoRepository.findById(produtoId).orElseThrow(
                () -> new ResourceNotFoundException("Produto inexistente pelo ID fornecido: " + produtoId)
        );

        produtoRepository.deleteById(produtoId);
    }
}
