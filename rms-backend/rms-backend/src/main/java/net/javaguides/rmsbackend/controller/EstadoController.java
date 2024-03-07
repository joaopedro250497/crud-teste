package net.javaguides.rmsbackend.controller;

import lombok.AllArgsConstructor;
import net.javaguides.rmsbackend.dto.EstadoDto;
import net.javaguides.rmsbackend.service.EstadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/estado")
public class EstadoController {

    private EstadoService estadoService;

    // Build Add Estado REST API
    @PostMapping
    public ResponseEntity<EstadoDto> createEstado(@RequestBody EstadoDto estadoDto){
        EstadoDto savedEstado = estadoService.createEstado(estadoDto);
        return new ResponseEntity<>(savedEstado, HttpStatus.CREATED);
    }

    // Build Get Estado REST API
    @GetMapping("{id}")
    public ResponseEntity<EstadoDto> getEstadoById(@PathVariable("id") Long estadoId){
        EstadoDto estadoDto = estadoService.getEstadoById(estadoId);
        return ResponseEntity.ok(estadoDto);
    }

    // Build Get All Estado REST API
    @GetMapping
    public ResponseEntity<List<EstadoDto>> getAllEstado(){
        List<EstadoDto> estado = estadoService.getAllEstado();
        return ResponseEntity.ok(estado);
    }

    // Build Update Estado REST API
    @PutMapping("{id}")
    public ResponseEntity<EstadoDto> updateEstado(@PathVariable("id") Long estadoId,
                                                    @RequestBody EstadoDto updatedEstado){
        EstadoDto estadoDto = estadoService.updateEstado(estadoId, updatedEstado);
        return ResponseEntity.ok(estadoDto);
    }

    // Build Delete Estado REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEstado(@PathVariable("id") Long estadoId){
        estadoService.deleteEstado(estadoId);
        return ResponseEntity.ok("Estado deletado com sucesso!");
    }

}
