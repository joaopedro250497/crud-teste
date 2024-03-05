package net.javaguides.rmsbackend.controller;

import lombok.AllArgsConstructor;
import net.javaguides.rmsbackend.dto.EmpresaDto;
import net.javaguides.rmsbackend.service.EmpresaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {

    private EmpresaService empresaService;

    // Build Add Empresa REST API
    @PostMapping
    public ResponseEntity<EmpresaDto> createEmpresa(@RequestBody EmpresaDto empresaDto){
        EmpresaDto savedEmpresa = empresaService.createEmpresa(empresaDto);
        return new ResponseEntity<>(savedEmpresa, HttpStatus.CREATED);
    }

    // Build Get Empresa REST API
    @GetMapping("{id}")
    public ResponseEntity<EmpresaDto> getEmpresaById(@PathVariable("id") Long empresaId){
        EmpresaDto empresaDto = empresaService.getEmpresaById(empresaId);
        return ResponseEntity.ok(empresaDto);
    }

    // Build Get All Empresas REST API
    @GetMapping
    public ResponseEntity<List<EmpresaDto>> getAllEmpresas(){
        List<EmpresaDto> empresas = empresaService.getAllEmpresas();
        return ResponseEntity.ok(empresas);
    }

    // Build Update Empresa REST API
    @PutMapping("{id}")
    public ResponseEntity<EmpresaDto> updateEmpresa(@PathVariable("id") Long empresaId,
                                                    @RequestBody EmpresaDto updatedEmpresa){
        EmpresaDto empresaDto = empresaService.updateEmpresa(empresaId, updatedEmpresa);
        return ResponseEntity.ok(empresaDto);
    }

    // Build Delete Empresa REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmpresa(@PathVariable("id") Long empresaId){
        empresaService.deleteEmpresa(empresaId);
        return ResponseEntity.ok("Empresa deletada com sucesso!");
    }

}
