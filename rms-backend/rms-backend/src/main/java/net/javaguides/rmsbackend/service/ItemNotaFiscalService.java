package net.javaguides.rmsbackend.service;

import net.javaguides.rmsbackend.dto.ItemNotaFiscalDto;

import java.util.List;

public interface ItemNotaFiscalService {
    ItemNotaFiscalDto createItemNotaFiscal(ItemNotaFiscalDto itemNotaFiscalDto);

    ItemNotaFiscalDto getItemNotaFiscalById(Long itemNotaFiscalId);

    List<ItemNotaFiscalDto> getAllItemNotaFiscal();

    ItemNotaFiscalDto updateItemNotaFiscal(Long itemNotaFiscalId, ItemNotaFiscalDto updatedItemNotaFiscal);

    void deleteItemNotaFiscal(Long itemNotaFiscalId);
}
