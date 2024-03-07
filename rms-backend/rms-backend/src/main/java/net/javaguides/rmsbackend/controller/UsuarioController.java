package net.javaguides.rmsbackend.controller;

import lombok.AllArgsConstructor;
import net.javaguides.rmsbackend.dto.UsuarioDto;
import net.javaguides.rmsbackend.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    private UsuarioService usuarioService;

    // Build Add Usuario REST API
    @PostMapping
    public ResponseEntity<UsuarioDto> createEmpresa(@RequestBody UsuarioDto usuarioDto){
        UsuarioDto savedUsuario = usuarioService.createUsuario(usuarioDto);
        return new ResponseEntity<>(savedUsuario, HttpStatus.CREATED);
    }

    // Build Get Usuario REST API
    @GetMapping("{id}")
    public ResponseEntity<UsuarioDto> getUsuarioById(@PathVariable("id") Long usuarioId){
        UsuarioDto usuarioDto = usuarioService.getUsuarioById(usuarioId);
        return ResponseEntity.ok(usuarioDto);
    }

    // Build Get All Usuario REST API
    @GetMapping
    public ResponseEntity<List<UsuarioDto>> getAllUsuario(){
        List<UsuarioDto> usuario = usuarioService.getAllUsuario();
        return ResponseEntity.ok(usuario);
    }

    // Build Update Usuario REST API
    @PutMapping("{id}")
    public ResponseEntity<UsuarioDto> updateUsuario(@PathVariable("id") Long usuarioId,
                                                    @RequestBody UsuarioDto updatedUsuario){
        UsuarioDto usuarioDto = usuarioService.updateUsuario(usuarioId, updatedUsuario);
        return ResponseEntity.ok(usuarioDto);
    }

    // Build Delete Usuario REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUsuario(@PathVariable("id") Long usuarioId){
        usuarioService.deleteUsuario(usuarioId);
        return ResponseEntity.ok("Usuário deletado com sucesso!");
    }

}
