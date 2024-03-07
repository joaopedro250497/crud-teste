package net.javaguides.rmsbackend.controller;

import lombok.AllArgsConstructor;
import net.javaguides.rmsbackend.dto.ProdutoDto;
import net.javaguides.rmsbackend.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    private ProdutoService produtoService;

    // Build Add Produto REST API
    @PostMapping
    public ResponseEntity<ProdutoDto> createProduto(@RequestBody ProdutoDto produtoDto){
        ProdutoDto savedProduto = produtoService.createProduto(produtoDto);
        return new ResponseEntity<>(savedProduto, HttpStatus.CREATED);
    }

    // Build Get Produto REST API
    @GetMapping("{id}")
    public ResponseEntity<ProdutoDto> getProdutoById(@PathVariable("id") Long produtoId){
        ProdutoDto produtoDto = produtoService.getProdutoById(produtoId);
        return ResponseEntity.ok(produtoDto);
    }

    // Build Get All Produto REST API
    @GetMapping
    public ResponseEntity<List<ProdutoDto>> getAllProduto(){
        List<ProdutoDto> produto = produtoService.getAllProduto();
        return ResponseEntity.ok(produto);
    }

    // Build Update Produto REST API
    @PutMapping("{id}")
    public ResponseEntity<ProdutoDto> updateProduto(@PathVariable("id") Long produtoId,
                                                    @RequestBody ProdutoDto updatedProduto){
        ProdutoDto produtoDto = produtoService.updateProduto(produtoId, updatedProduto);
        return ResponseEntity.ok(produtoDto);
    }

    // Build Delete Produto REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProduto(@PathVariable("id") Long produtoId){
        produtoService.deleteProduto(produtoId);
        return ResponseEntity.ok("Produto deletado com sucesso!");
    }

}
