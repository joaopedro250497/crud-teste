package net.javaguides.rmsbackend.controller;

import lombok.AllArgsConstructor;
import net.javaguides.rmsbackend.dto.NotaFiscalColidenciaDto;
import net.javaguides.rmsbackend.service.NotaFiscalColidenciaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/notaFiscalColidencia")
public class NotaFiscalColidenciaController {

    private NotaFiscalColidenciaService notaFiscalColidenciaService;

    // Build Add NotaFiscalColidencia REST API
    @PostMapping
    public ResponseEntity<NotaFiscalColidenciaDto> createNotaFiscalColidencia(@RequestBody NotaFiscalColidenciaDto notaFiscalColidenciaDto){
        NotaFiscalColidenciaDto savedNotaFiscalColidencia = notaFiscalColidenciaService.createNotaFiscalColidencia(notaFiscalColidenciaDto);
        return new ResponseEntity<>(savedNotaFiscalColidencia, HttpStatus.CREATED);
    }

    // Build Get NotaFiscalColidencia REST API
    @GetMapping("{id}")
    public ResponseEntity<NotaFiscalColidenciaDto> getNotaFiscalColidenciaById(@PathVariable("id") Long notaFiscalColidenciaId){
        NotaFiscalColidenciaDto notaFiscalColidenciaDto = notaFiscalColidenciaService.getNotaFiscalColidenciaById(notaFiscalColidenciaId);
        return ResponseEntity.ok(notaFiscalColidenciaDto);
    }

    // Build Get All NotaFiscalColidencia REST API
    @GetMapping
    public ResponseEntity<List<NotaFiscalColidenciaDto>> getAllNotaFiscalColidencia(){
        List<NotaFiscalColidenciaDto> notaFiscalColidencia = notaFiscalColidenciaService.getAllNotaFiscalColidencia();
        return ResponseEntity.ok(notaFiscalColidencia);
    }

    // Build Update NotaFiscalColidencia REST API
    @PutMapping("{id}")
    public ResponseEntity<NotaFiscalColidenciaDto> updateNotaFiscalColidencia(@PathVariable("id") Long notaFiscalColidenciaId,
                                                    @RequestBody NotaFiscalColidenciaDto updatedNotaFiscalColidencia){
        NotaFiscalColidenciaDto notaFiscalColidenciaDto = notaFiscalColidenciaService.updateNotaFiscalColidencia(notaFiscalColidenciaId, updatedNotaFiscalColidencia);
        return ResponseEntity.ok(notaFiscalColidenciaDto);
    }

    // Build Delete NotaFiscalColidencia REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteNotaFiscalColidencia(@PathVariable("id") Long notaFiscalColidenciaId){
        notaFiscalColidenciaService.deleteNotaFiscalColidencia(notaFiscalColidenciaId);
        return ResponseEntity.ok("Colidência de nota fiscal deletada com sucesso!");
    }

}
