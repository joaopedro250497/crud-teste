package net.javaguides.rmsbackend.mapper;

import net.javaguides.rmsbackend.dto.PermissaoDto;
import net.javaguides.rmsbackend.entity.Permissao;

public class PermissaoMapper {

    public static PermissaoDto mapToPermissaoDto(Permissao permissao){
        return new PermissaoDto(
                permissao.getId(),
                permissao.getDescricao(),
                permissao.getSigla()
        );
    }

    public static Permissao mapToPermissao(PermissaoDto permissaoDto){
        return new Permissao(
                permissaoDto.getId(),
                permissaoDto.getDescricao(),
                permissaoDto.getSigla()
        );
    }
}
