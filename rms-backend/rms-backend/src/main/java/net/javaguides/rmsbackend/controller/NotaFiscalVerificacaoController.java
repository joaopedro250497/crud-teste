package net.javaguides.rmsbackend.controller;

import lombok.AllArgsConstructor;
import net.javaguides.rmsbackend.dto.NotaFiscalVerificacaoDto;
import net.javaguides.rmsbackend.service.NotaFiscalVerificacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/notaFiscalVerificacao")
public class NotaFiscalVerificacaoController {

    private NotaFiscalVerificacaoService notaFiscalVerificacaoService;

    // Build Add NotaFiscalVerificacao REST API
    @PostMapping
    public ResponseEntity<NotaFiscalVerificacaoDto> createNotaFiscalVerificacao(@RequestBody NotaFiscalVerificacaoDto notaFiscalVerificacaoDto){
        NotaFiscalVerificacaoDto savedNotaFiscalVerificacao = notaFiscalVerificacaoService.createNotaFiscalVerificacao(notaFiscalVerificacaoDto);
        return new ResponseEntity<>(savedNotaFiscalVerificacao, HttpStatus.CREATED);
    }

    // Build Get NotaFiscalVerificacao REST API
    @GetMapping("{id}")
    public ResponseEntity<NotaFiscalVerificacaoDto> getNotaFiscalVerificacaoById(@PathVariable("id") Long notaFiscalVerificacaoId){
        NotaFiscalVerificacaoDto notaFiscalVerificacaoDto = notaFiscalVerificacaoService.getNotaFiscalVerificacaoById(notaFiscalVerificacaoId);
        return ResponseEntity.ok(notaFiscalVerificacaoDto);
    }

    // Build Get All NotaFiscalVerificacaos REST API
    @GetMapping
    public ResponseEntity<List<NotaFiscalVerificacaoDto>> getAllNotaFiscalVerificacao(){
        List<NotaFiscalVerificacaoDto> notaFiscalVerificacao = notaFiscalVerificacaoService.getAllNotaFiscalVerificacao();
        return ResponseEntity.ok(notaFiscalVerificacao);
    }

    // Build Update NotaFiscalVerificacao REST API
    @PutMapping("{id}")
    public ResponseEntity<NotaFiscalVerificacaoDto> updateNotaFiscalVerificacao(@PathVariable("id") Long notaFiscalVerificacaoId,
                                                    @RequestBody NotaFiscalVerificacaoDto updatedNotaFiscalVerificacao){
        NotaFiscalVerificacaoDto notaFiscalVerificacaoDto = notaFiscalVerificacaoService.updateNotaFiscalVerificacao(notaFiscalVerificacaoId, updatedNotaFiscalVerificacao);
        return ResponseEntity.ok(notaFiscalVerificacaoDto);
    }

    // Build Delete NotaFiscalVerificacao REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteNotaFiscalVerificacao(@PathVariable("id") Long notaFiscalVerificacaoId){
        notaFiscalVerificacaoService.deleteNotaFiscalVerificacao(notaFiscalVerificacaoId);
        return ResponseEntity.ok("Verificação de nota fiscal deletada com sucesso!");
    }

}
