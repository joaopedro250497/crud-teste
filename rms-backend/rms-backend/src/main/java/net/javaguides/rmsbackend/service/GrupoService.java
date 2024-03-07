package net.javaguides.rmsbackend.service;

import net.javaguides.rmsbackend.dto.GrupoDto;

import java.util.List;

public interface GrupoService {
    GrupoDto createGrupo(GrupoDto grupoDto);

    GrupoDto getGrupoById(Long grupoId);

    List<GrupoDto> getAllGrupo();

    GrupoDto updateGrupo(Long grupoId, GrupoDto updatedGrupo);

    void deleteGrupo(Long grupoId);
}
