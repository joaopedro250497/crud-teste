package net.javaguides.rmsbackend.service;

import net.javaguides.rmsbackend.dto.UsuarioDto;

import java.util.List;

public interface UsuarioService {
    UsuarioDto createUsuario(UsuarioDto usuarioDto);

    UsuarioDto getUsuarioById(Long usuarioId);

    List<UsuarioDto> getAllUsuario();

    UsuarioDto updateUsuario(Long usuarioId, UsuarioDto updatedUsuario);

    void deleteUsuario(Long usuarioId);
}
