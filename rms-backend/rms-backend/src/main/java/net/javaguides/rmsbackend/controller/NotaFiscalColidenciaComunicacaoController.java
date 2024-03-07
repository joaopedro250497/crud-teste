package net.javaguides.rmsbackend.controller;

import lombok.AllArgsConstructor;
import net.javaguides.rmsbackend.dto.NotaFiscalColidenciaComunicacaoDto;
import net.javaguides.rmsbackend.service.NotaFiscalColidenciaComunicacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/notaFiscalColidenciaComunicacao")
public class NotaFiscalColidenciaComunicacaoController {

    private NotaFiscalColidenciaComunicacaoService notaFiscalColidenciaComunicacaoService;

    // Build Add NotaFiscalColidenciaComunicacao REST API
    @PostMapping
    public ResponseEntity<NotaFiscalColidenciaComunicacaoDto> createNotaFiscalColidenciaComunicacao(@RequestBody NotaFiscalColidenciaComunicacaoDto notaFiscalColidenciaComunicacaoDto){
        NotaFiscalColidenciaComunicacaoDto savedNotaFiscalColidenciaComunicacao = notaFiscalColidenciaComunicacaoService.createNotaFiscalColidenciaComunicacao(notaFiscalColidenciaComunicacaoDto);
        return new ResponseEntity<>(savedNotaFiscalColidenciaComunicacao, HttpStatus.CREATED);
    }

    // Build Get NotaFiscalColidenciaComunicacao REST API
    @GetMapping("{id}")
    public ResponseEntity<NotaFiscalColidenciaComunicacaoDto> getNotaFiscalColidenciaComunicacaoById(@PathVariable("id") Long notaFiscalColidenciaComunicacaoId){
        NotaFiscalColidenciaComunicacaoDto notaFiscalColidenciaComunicacaoDto = notaFiscalColidenciaComunicacaoService.getNotaFiscalColidenciaComunicacaoById(notaFiscalColidenciaComunicacaoId);
        return ResponseEntity.ok(notaFiscalColidenciaComunicacaoDto);
    }

    // Build Get All NotaFiscalColidenciaComunicacao REST API
    @GetMapping
    public ResponseEntity<List<NotaFiscalColidenciaComunicacaoDto>> getAllNotaFiscalColidenciaComunicacao(){
        List<NotaFiscalColidenciaComunicacaoDto> notaFiscalColidenciaComunicacao = notaFiscalColidenciaComunicacaoService.getAllNotaFiscalColidenciaComunicacao();
        return ResponseEntity.ok(notaFiscalColidenciaComunicacao);
    }

    // Build Update NotaFiscalColidenciaComunicacao REST API
    @PutMapping("{id}")
    public ResponseEntity<NotaFiscalColidenciaComunicacaoDto> updateNotaFiscalColidenciaComunicacao(@PathVariable("id") Long notaFiscalColidenciaComunicacaoId,
                                                    @RequestBody NotaFiscalColidenciaComunicacaoDto updatedNotaFiscalColidenciaComunicacao){
        NotaFiscalColidenciaComunicacaoDto notaFiscalColidenciaComunicacaoDto = notaFiscalColidenciaComunicacaoService.updateNotaFiscalColidenciaComunicacao(notaFiscalColidenciaComunicacaoId, updatedNotaFiscalColidenciaComunicacao);
        return ResponseEntity.ok(notaFiscalColidenciaComunicacaoDto);
    }

    // Build Delete NotaFiscalColidenciaComunicacao REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteNotaFiscalColidenciaComunicacao(@PathVariable("id") Long notaFiscalColidenciaComunicacaoId){
        notaFiscalColidenciaComunicacaoService.deleteNotaFiscalColidenciaComunicacao(notaFiscalColidenciaComunicacaoId);
        return ResponseEntity.ok("Comunicação de colidência de nota fiscal deletada com sucesso!");
    }

}
