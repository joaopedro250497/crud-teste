package net.javaguides.rmsbackend.controller;

import lombok.AllArgsConstructor;
import net.javaguides.rmsbackend.dto.UnidadeDto;
import net.javaguides.rmsbackend.service.UnidadeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/unidade")
public class UnidadeController {

    private UnidadeService unidadeService;

    // Build Add Unidade REST API
    @PostMapping
    public ResponseEntity<UnidadeDto> createUnidade(@RequestBody UnidadeDto unidadeDto){
        UnidadeDto savedUnidade = unidadeService.createUnidade(unidadeDto);
        return new ResponseEntity<>(savedUnidade, HttpStatus.CREATED);
    }

    // Build Get Unidade REST API
    @GetMapping("{id}")
    public ResponseEntity<UnidadeDto> getUnidadeById(@PathVariable("id") Long unidadeId){
        UnidadeDto unidadeDto = unidadeService.getUnidadeById(unidadeId);
        return ResponseEntity.ok(unidadeDto);
    }

    // Build Get All Unidades REST API
    @GetMapping
    public ResponseEntity<List<UnidadeDto>> getAllUnidade(){
        List<UnidadeDto> unidade = unidadeService.getAllUnidade();
        return ResponseEntity.ok(unidade);
    }

    // Build Update Unidade REST API
    @PutMapping("{id}")
    public ResponseEntity<UnidadeDto> updateUnidade(@PathVariable("id") Long unidadeId,
                                                    @RequestBody UnidadeDto updatedUnidade){
        UnidadeDto unidadeDto = unidadeService.updateUnidade(unidadeId, updatedUnidade);
        return ResponseEntity.ok(unidadeDto);
    }

    // Build Delete Unidade REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUnidade(@PathVariable("id") Long unidadeId){
        unidadeService.deleteUnidade(unidadeId);
        return ResponseEntity.ok("Unidade deletada com sucesso!");
    }

}
