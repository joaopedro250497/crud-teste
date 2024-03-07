package net.javaguides.rmsbackend.service;

import net.javaguides.rmsbackend.dto.PermissaoDto;

import java.util.List;

public interface PermissaoService {
    PermissaoDto createPermissao(PermissaoDto permissaoDto);

    PermissaoDto getPermissaoById(Long permissaoId);

    List<PermissaoDto> getAllPermissao();

    PermissaoDto updatePermissao(Long permissaoId, PermissaoDto updatedPermissao);

    void deletePermissao(Long permissaoId);
}
