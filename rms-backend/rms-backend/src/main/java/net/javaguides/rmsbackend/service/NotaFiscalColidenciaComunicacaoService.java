package net.javaguides.rmsbackend.service;

import net.javaguides.rmsbackend.dto.NotaFiscalColidenciaComunicacaoDto;

import java.util.List;

public interface NotaFiscalColidenciaComunicacaoService {
    NotaFiscalColidenciaComunicacaoDto createNotaFiscalColidenciaComunicacao(NotaFiscalColidenciaComunicacaoDto notaFiscalColidenciaComunicacaoDto);

    NotaFiscalColidenciaComunicacaoDto getNotaFiscalColidenciaComunicacaoById(Long notaFiscalColidenciaComunicacaoId);

    List<NotaFiscalColidenciaComunicacaoDto> getAllNotaFiscalColidenciaComunicacao();

    NotaFiscalColidenciaComunicacaoDto updateNotaFiscalColidenciaComunicacao(Long notaFiscalColidenciaComunicacaoId, NotaFiscalColidenciaComunicacaoDto updatedNotaFiscalColidenciaComunicacao);

    void deleteNotaFiscalColidenciaComunicacao(Long notaFiscalColidenciaComunicacaoId);
}
