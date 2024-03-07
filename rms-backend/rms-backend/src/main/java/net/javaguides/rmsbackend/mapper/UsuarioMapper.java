package net.javaguides.rmsbackend.mapper;

import net.javaguides.rmsbackend.dto.UsuarioDto;
import net.javaguides.rmsbackend.entity.Usuario;

public class UsuarioMapper {

    public static UsuarioDto mapToUsuarioDto(Usuario usuario){
        return new UsuarioDto(
                usuario.getId(),
                usuario.getEmail(),
                usuario.getNome(),
                usuario.getCpf(),
                usuario.getAtivo(),
                usuario.getAdministrador(),
                usuario.getDataRegistro(),
                usuario.getDataBloqueio()
        );
    }

    public static Usuario mapToUsuario(UsuarioDto usuarioDto){
        return new Usuario(
                usuarioDto.getId(),
                usuarioDto.getEmail(),
                usuarioDto.getNome(),
                usuarioDto.getCpf(),
                usuarioDto.getAtivo(),
                usuarioDto.getAdministrador(),
                usuarioDto.getDataRegistro(),
                usuarioDto.getDataBloqueio()
        );
    }
}
