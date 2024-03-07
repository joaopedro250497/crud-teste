package net.javaguides.rmsbackend.controller;

import lombok.AllArgsConstructor;
import net.javaguides.rmsbackend.dto.NCMDto;
import net.javaguides.rmsbackend.service.NCMService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/nCM")
public class NCMController {

    private NCMService nCMService;

    // Build Add NCM REST API
    @PostMapping
    public ResponseEntity<NCMDto> createNCM(@RequestBody NCMDto nCMDto){
        NCMDto savedNCM = nCMService.createNCM(nCMDto);
        return new ResponseEntity<>(savedNCM, HttpStatus.CREATED);
    }

    // Build Get NCM REST API
    @GetMapping("{id}")
    public ResponseEntity<NCMDto> getNCMById(@PathVariable("id") Long nCMId){
        NCMDto nCMDto = nCMService.getNCMById(nCMId);
        return ResponseEntity.ok(nCMDto);
    }

    // Build Get All NCM REST API
    @GetMapping
    public ResponseEntity<List<NCMDto>> getAllNCM(){
        List<NCMDto> nCM = nCMService.getAllNCM();
        return ResponseEntity.ok(nCM);
    }

    // Build Update NCM REST API
    @PutMapping("{id}")
    public ResponseEntity<NCMDto> updateNCM(@PathVariable("id") Long nCMId,
                                                    @RequestBody NCMDto updatedNCM){
        NCMDto nCMDto = nCMService.updateNCM(nCMId, updatedNCM);
        return ResponseEntity.ok(nCMDto);
    }

    // Build Delete NCM REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteNCM(@PathVariable("id") Long nCMId){
        nCMService.deleteNCM(nCMId);
        return ResponseEntity.ok("NCM deletado com sucesso!");
    }

}
