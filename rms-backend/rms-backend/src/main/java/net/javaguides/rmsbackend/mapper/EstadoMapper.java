package net.javaguides.rmsbackend.mapper;

import net.javaguides.rmsbackend.dto.EstadoDto;
import net.javaguides.rmsbackend.entity.Estado;

public class EstadoMapper {

    public static EstadoDto mapToEstadoDto(Estado estado){
        return new EstadoDto(
                estado.getId(),
                estado.getDescricao()
        );
    }

    public static Estado mapToEstado(EstadoDto estadoDto){
        return new Estado(
                estadoDto.getId(),
                estadoDto.getDescricao()
        );
    }
}
