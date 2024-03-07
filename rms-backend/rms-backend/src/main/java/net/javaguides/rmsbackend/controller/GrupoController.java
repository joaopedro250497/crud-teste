package net.javaguides.rmsbackend.controller;

import lombok.AllArgsConstructor;
import net.javaguides.rmsbackend.dto.GrupoDto;
import net.javaguides.rmsbackend.service.GrupoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/grupo")
public class GrupoController {

    private GrupoService grupoService;

    // Build Add Grupo REST API
    @PostMapping
    public ResponseEntity<GrupoDto> createGrupo(@RequestBody GrupoDto grupoDto){
        GrupoDto savedGrupo = grupoService.createGrupo(grupoDto);
        return new ResponseEntity<>(savedGrupo, HttpStatus.CREATED);
    }

    // Build Get Grupo REST API
    @GetMapping("{id}")
    public ResponseEntity<GrupoDto> getGrupoById(@PathVariable("id") Long grupoId){
        GrupoDto grupoDto = grupoService.getGrupoById(grupoId);
        return ResponseEntity.ok(grupoDto);
    }

    // Build Get All Grupo REST API
    @GetMapping
    public ResponseEntity<List<GrupoDto>> getAllGrupo(){
        List<GrupoDto> grupo = grupoService.getAllGrupo();
        return ResponseEntity.ok(grupo);
    }

    // Build Update Grupo REST API
    @PutMapping("{id}")
    public ResponseEntity<GrupoDto> updateGrupo(@PathVariable("id") Long grupoId,
                                                    @RequestBody GrupoDto updatedGrupo){
        GrupoDto grupoDto = grupoService.updateGrupo(grupoId, updatedGrupo);
        return ResponseEntity.ok(grupoDto);
    }

    // Build Delete Grupo REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteGrupo(@PathVariable("id") Long grupoId){
        grupoService.deleteGrupo(grupoId);
        return ResponseEntity.ok("Grupo deletado com sucesso!");
    }

}
