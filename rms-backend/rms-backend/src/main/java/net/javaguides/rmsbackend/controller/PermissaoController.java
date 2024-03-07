package net.javaguides.rmsbackend.controller;

import lombok.AllArgsConstructor;
import net.javaguides.rmsbackend.dto.PermissaoDto;
import net.javaguides.rmsbackend.service.PermissaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/permissao")
public class PermissaoController {

    private PermissaoService permissaoService;

    // Build Add Permissao REST API
    @PostMapping
    public ResponseEntity<PermissaoDto> createPermissao(@RequestBody PermissaoDto permissaoDto){
        PermissaoDto savedPermissao = permissaoService.createPermissao(permissaoDto);
        return new ResponseEntity<>(savedPermissao, HttpStatus.CREATED);
    }

    // Build Get Permissao REST API
    @GetMapping("{id}")
    public ResponseEntity<PermissaoDto> getPermissaoById(@PathVariable("id") Long permissaoId){
        PermissaoDto permissaoDto = permissaoService.getPermissaoById(permissaoId);
        return ResponseEntity.ok(permissaoDto);
    }

    // Build Get All Permissao REST API
    @GetMapping
    public ResponseEntity<List<PermissaoDto>> getAllPermissao(){
        List<PermissaoDto> permissao = permissaoService.getAllPermissao();
        return ResponseEntity.ok(permissao);
    }

    // Build Update Permissao REST API
    @PutMapping("{id}")
    public ResponseEntity<PermissaoDto> updatePermissao(@PathVariable("id") Long permissaoId,
                                                    @RequestBody PermissaoDto updatedPermissao){
        PermissaoDto permissaoDto = permissaoService.updatePermissao(permissaoId, updatedPermissao);
        return ResponseEntity.ok(permissaoDto);
    }

    // Build Delete Permissao REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePermissao(@PathVariable("id") Long permissaoId){
        permissaoService.deletePermissao(permissaoId);
        return ResponseEntity.ok("Permissão deletada com sucesso!");
    }

}
