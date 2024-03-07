package net.javaguides.rmsbackend.controller;

import lombok.AllArgsConstructor;
import net.javaguides.rmsbackend.dto.ItemNotaFiscalDto;
import net.javaguides.rmsbackend.service.ItemNotaFiscalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/itemNotaFiscal")
public class ItemNotaFiscalController {

    private ItemNotaFiscalService itemNotaFiscalService;

    // Build Add ItemNotaFiscal REST API
    @PostMapping
    public ResponseEntity<ItemNotaFiscalDto> createItemNotaFiscal(@RequestBody ItemNotaFiscalDto itemNotaFiscalDto){
        ItemNotaFiscalDto savedItemNotaFiscal = itemNotaFiscalService.createItemNotaFiscal(itemNotaFiscalDto);
        return new ResponseEntity<>(savedItemNotaFiscal, HttpStatus.CREATED);
    }

    // Build Get ItemNotaFiscal REST API
    @GetMapping("{id}")
    public ResponseEntity<ItemNotaFiscalDto> getItemNotaFiscalById(@PathVariable("id") Long itemNotaFiscalId){
        ItemNotaFiscalDto itemNotaFiscalDto = itemNotaFiscalService.getItemNotaFiscalById(itemNotaFiscalId);
        return ResponseEntity.ok(itemNotaFiscalDto);
    }

    // Build Get All ItemNotaFiscal REST API
    @GetMapping
    public ResponseEntity<List<ItemNotaFiscalDto>> getAllItemNotaFiscal(){
        List<ItemNotaFiscalDto> itemNotaFiscal = itemNotaFiscalService.getAllItemNotaFiscal();
        return ResponseEntity.ok(itemNotaFiscal);
    }

    // Build Update ItemNotaFiscal REST API
    @PutMapping("{id}")
    public ResponseEntity<ItemNotaFiscalDto> updateItemNotaFiscal(@PathVariable("id") Long itemNotaFiscalId,
                                                    @RequestBody ItemNotaFiscalDto updatedItemNotaFiscal){
        ItemNotaFiscalDto itemNotaFiscalDto = itemNotaFiscalService.updateItemNotaFiscal(itemNotaFiscalId, updatedItemNotaFiscal);
        return ResponseEntity.ok(itemNotaFiscalDto);
    }

    // Build Delete ItemNotaFiscal REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteItemNotaFiscal(@PathVariable("id") Long itemNotaFiscalId){
        itemNotaFiscalService.deleteItemNotaFiscal(itemNotaFiscalId);
        return ResponseEntity.ok("Item de nota fiscal deletado com sucesso!");
    }

}
