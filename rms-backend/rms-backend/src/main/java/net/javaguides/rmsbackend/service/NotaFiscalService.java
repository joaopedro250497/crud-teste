package net.javaguides.rmsbackend.service;

import net.javaguides.rmsbackend.dto.NotaFiscalDto;

import java.util.List;

public interface NotaFiscalService {
    NotaFiscalDto createNotaFiscal(NotaFiscalDto notaFiscalDto);

    NotaFiscalDto getNotaFiscalById(Long notaFiscalId);

    List<NotaFiscalDto> getAllNotaFiscal();

    NotaFiscalDto updateNotaFiscal(Long notaFiscalId, NotaFiscalDto updatedNotaFiscal);

    void deleteNotaFiscal(Long notaFiscalId);
}
