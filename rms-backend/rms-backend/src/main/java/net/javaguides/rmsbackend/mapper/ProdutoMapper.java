package net.javaguides.rmsbackend.mapper;

import net.javaguides.rmsbackend.dto.ProdutoDto;
import net.javaguides.rmsbackend.entity.Produto;

public class ProdutoMapper {

    public static ProdutoDto mapToProdutoDto(Produto produto){
        return new ProdutoDto(
                produto.getId(),
                produto.getDescricao()
        );
    }

    public static Produto mapToProduto(ProdutoDto produtoDto){
        return new Produto(
                produtoDto.getId(),
                produtoDto.getDescricao()
        );
    }
}
