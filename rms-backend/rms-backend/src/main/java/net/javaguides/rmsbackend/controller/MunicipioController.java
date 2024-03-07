package net.javaguides.rmsbackend.controller;

import lombok.AllArgsConstructor;
import net.javaguides.rmsbackend.dto.MunicipioDto;
import net.javaguides.rmsbackend.service.MunicipioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/municipio")
public class MunicipioController {

    private MunicipioService municipioService;

    // Build Add Municipio REST API
    @PostMapping
    public ResponseEntity<MunicipioDto> createMunicipio(@RequestBody MunicipioDto municipioDto){
        MunicipioDto savedMunicipio = municipioService.createMunicipio(municipioDto);
        return new ResponseEntity<>(savedMunicipio, HttpStatus.CREATED);
    }

    // Build Get Municipio REST API
    @GetMapping("{id}")
    public ResponseEntity<MunicipioDto> getMunicipioById(@PathVariable("id") Long municipioId){
        MunicipioDto municipioDto = municipioService.getMunicipioById(municipioId);
        return ResponseEntity.ok(municipioDto);
    }

    // Build Get All Municipio REST API
    @GetMapping
    public ResponseEntity<List<MunicipioDto>> getAllMunicipio(){
        List<MunicipioDto> municipio = municipioService.getAllMunicipio();
        return ResponseEntity.ok(municipio);
    }

    // Build Update Municipio REST API
    @PutMapping("{id}")
    public ResponseEntity<MunicipioDto> updateMunicipio(@PathVariable("id") Long municipioId,
                                                    @RequestBody MunicipioDto updatedMunicipio){
        MunicipioDto municipioDto = municipioService.updateMunicipio(municipioId, updatedMunicipio);
        return ResponseEntity.ok(municipioDto);
    }

    // Build Delete Municipio REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteMunicipio(@PathVariable("id") Long municipioId){
        municipioService.deleteMunicipio(municipioId);
        return ResponseEntity.ok("Município deletado com sucesso!");
    }

}
