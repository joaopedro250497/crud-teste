package net.javaguides.rmsbackend.service;

import net.javaguides.rmsbackend.dto.EstadoDto;

import java.util.List;

public interface EstadoService {
    EstadoDto createEstado(EstadoDto estadoDto);

    EstadoDto getEstadoById(Long estadoId);

    List<EstadoDto> getAllEstado();

    EstadoDto updateEstado(Long estadoId, EstadoDto updatedEstado);

    void deleteEstado(Long estadoId);
}
