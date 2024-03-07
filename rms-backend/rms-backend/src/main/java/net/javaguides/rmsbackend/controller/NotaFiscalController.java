package net.javaguides.rmsbackend.controller;

import lombok.AllArgsConstructor;
import net.javaguides.rmsbackend.dto.NotaFiscalDto;
import net.javaguides.rmsbackend.service.NotaFiscalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/notaFiscal")
public class NotaFiscalController {

    private NotaFiscalService notaFiscalService;

    // Build Add NotaFiscal REST API
    @PostMapping
    public ResponseEntity<NotaFiscalDto> createNotaFiscal(@RequestBody NotaFiscalDto notaFiscalDto){
        NotaFiscalDto savedNotaFiscal = notaFiscalService.createNotaFiscal(notaFiscalDto);
        return new ResponseEntity<>(savedNotaFiscal, HttpStatus.CREATED);
    }

    // Build Get NotaFiscal REST API
    @GetMapping("{id}")
    public ResponseEntity<NotaFiscalDto> getNotaFiscalById(@PathVariable("id") Long notaFiscalId){
        NotaFiscalDto notaFiscalDto = notaFiscalService.getNotaFiscalById(notaFiscalId);
        return ResponseEntity.ok(notaFiscalDto);
    }

    // Build Get All NotaFiscal REST API
    @GetMapping
    public ResponseEntity<List<NotaFiscalDto>> getAllNotaFiscal(){
        List<NotaFiscalDto> notaFiscal = notaFiscalService.getAllNotaFiscal();
        return ResponseEntity.ok(notaFiscal);
    }

    // Build Update NotaFiscal REST API
    @PutMapping("{id}")
    public ResponseEntity<NotaFiscalDto> updateNotaFiscal(@PathVariable("id") Long notaFiscalId,
                                                    @RequestBody NotaFiscalDto updatedNotaFiscal){
        NotaFiscalDto notaFiscalDto = notaFiscalService.updateNotaFiscal(notaFiscalId, updatedNotaFiscal);
        return ResponseEntity.ok(notaFiscalDto);
    }

    // Build Delete NotaFiscal REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteNotaFiscal(@PathVariable("id") Long notaFiscalId){
        notaFiscalService.deleteNotaFiscal(notaFiscalId);
        return ResponseEntity.ok("Nota fiscal deletada com sucesso!");
    }

}
