package net.javaguides.rmsbackend.mapper;

import net.javaguides.rmsbackend.dto.ItemNotaFiscalDto;
import net.javaguides.rmsbackend.entity.ItemNotaFiscal;

public class ItemNotaFiscalMapper {

    public static ItemNotaFiscalDto mapToItemNotaFiscalDto(ItemNotaFiscal itemNotaFiscal){
        return new ItemNotaFiscalDto(
                itemNotaFiscal.getId(),
                itemNotaFiscal.getQuantidade(),
                itemNotaFiscal.getValorUnitario(),
                itemNotaFiscal.getValorProduto()
        );
    }

    public static ItemNotaFiscal mapToItemNotaFiscal(ItemNotaFiscalDto itemNotaFiscal){
        return new ItemNotaFiscal(
                itemNotaFiscal.getId(),
                itemNotaFiscal.getQuantidade(),
                itemNotaFiscal.getValorUnitario(),
                itemNotaFiscal.getValorProduto()
        );
    }
}
