package net.javaguides.rmsbackend.service.Impl;

import lombok.AllArgsConstructor;
import net.javaguides.rmsbackend.dto.ItemNotaFiscalDto;
import net.javaguides.rmsbackend.entity.ItemNotaFiscal;
import net.javaguides.rmsbackend.exception.ResourceNotFoundException;
import net.javaguides.rmsbackend.mapper.ItemNotaFiscalMapper;
import net.javaguides.rmsbackend.repository.ItemNotaFiscalRepository;
import net.javaguides.rmsbackend.service.ItemNotaFiscalService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ItemNotaFiscalServiceImpl implements ItemNotaFiscalService {

    private ItemNotaFiscalRepository itemNotaFiscalRepository;

    @Override
    public ItemNotaFiscalDto createItemNotaFiscal(ItemNotaFiscalDto itemNotaFiscalDto) {

        ItemNotaFiscal itemNotaFiscal = ItemNotaFiscalMapper.mapToItemNotaFiscal(itemNotaFiscalDto);
        ItemNotaFiscal savedItemNotaFiscal = itemNotaFiscalRepository.save(itemNotaFiscal);
        return ItemNotaFiscalMapper.mapToItemNotaFiscalDto(savedItemNotaFiscal);
    }

    @Override
    public ItemNotaFiscalDto getItemNotaFiscalById(Long itemNotaFiscalId) {
        ItemNotaFiscal itemNotaFiscal = itemNotaFiscalRepository.findById(itemNotaFiscalId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Item Nota Fiscal inexistente pelo ID fornecido: " + itemNotaFiscalId));
        return ItemNotaFiscalMapper.mapToItemNotaFiscalDto(itemNotaFiscal);
    }

    @Override
    public List<ItemNotaFiscalDto> getAllItemNotaFiscal() {
        List<ItemNotaFiscal> itemNotaFiscals = itemNotaFiscalRepository.findAll();
        return itemNotaFiscals.stream().map((itemNotaFiscal) -> ItemNotaFiscalMapper.mapToItemNotaFiscalDto(itemNotaFiscal))
                .collect(Collectors.toList());
    }

    @Override
    public ItemNotaFiscalDto updateItemNotaFiscal(Long itemNotaFiscalId, ItemNotaFiscalDto updatedItemNotaFiscal) {

        ItemNotaFiscal itemNotaFiscal = itemNotaFiscalRepository.findById(itemNotaFiscalId).orElseThrow(
                () -> new ResourceNotFoundException("Item Nota Fiscal inexistente pelo ID fornecido: " + itemNotaFiscalId)
        );


        itemNotaFiscal.setQuantidade(updatedItemNotaFiscal.getQuantidade());
        itemNotaFiscal.setValorUnitario(updatedItemNotaFiscal.getValorUnitario());
        itemNotaFiscal.setValorProduto(updatedItemNotaFiscal.getValorProduto());

        ItemNotaFiscal updatedItemNotaFiscalObj = itemNotaFiscalRepository.save(itemNotaFiscal);

        return ItemNotaFiscalMapper.mapToItemNotaFiscalDto(updatedItemNotaFiscalObj);
    }

    @Override
    public void deleteItemNotaFiscal(Long itemNotaFiscalId) {

        ItemNotaFiscal itemNotaFiscal = itemNotaFiscalRepository.findById(itemNotaFiscalId).orElseThrow(
                () -> new ResourceNotFoundException("ItemNotaFiscal inexistente pelo ID fornecido: " + itemNotaFiscalId)
        );

        itemNotaFiscalRepository.deleteById(itemNotaFiscalId);
    }
}
