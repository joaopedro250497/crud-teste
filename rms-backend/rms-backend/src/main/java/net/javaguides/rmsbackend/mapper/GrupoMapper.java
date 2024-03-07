package net.javaguides.rmsbackend.mapper;

import net.javaguides.rmsbackend.dto.GrupoDto;
import net.javaguides.rmsbackend.entity.Grupo;

public class GrupoMapper {

    public static GrupoDto mapToGrupoDto(Grupo grupo){
        return new GrupoDto(
                grupo.getId(),
                grupo.getDescricao()
        );
    }

    public static Grupo mapToGrupo(GrupoDto grupoDto){
        return new Grupo(
                grupoDto.getId(),
                grupoDto.getDescricao()
        );
    }
}
