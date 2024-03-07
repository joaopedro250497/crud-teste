package net.javaguides.rmsbackend.service;

import net.javaguides.rmsbackend.dto.NotaFiscalColidenciaDto;

import java.util.List;

public interface NotaFiscalColidenciaService {
    NotaFiscalColidenciaDto createNotaFiscalColidencia(NotaFiscalColidenciaDto notaFiscalColidenciaDto);

    NotaFiscalColidenciaDto getNotaFiscalColidenciaById(Long notaFiscalColidenciaId);

    List<NotaFiscalColidenciaDto> getAllNotaFiscalColidencia();

    NotaFiscalColidenciaDto updateNotaFiscalColidencia(Long notaFiscalColidenciaId, NotaFiscalColidenciaDto updatedNotaFiscalColidencia);

    void deleteNotaFiscalColidencia(Long notaFiscalColidenciaId);
}
