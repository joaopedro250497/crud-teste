package net.javaguides.rmsbackend.service;

import net.javaguides.rmsbackend.dto.NotaFiscalVerificacaoDto;

import java.util.List;

public interface NotaFiscalVerificacaoService {
    NotaFiscalVerificacaoDto createNotaFiscalVerificacao(NotaFiscalVerificacaoDto notaFiscalVerificacaoDto);

    NotaFiscalVerificacaoDto getNotaFiscalVerificacaoById(Long notaFiscalVerificacaoId);

    List<NotaFiscalVerificacaoDto> getAllNotaFiscalVerificacao();

    NotaFiscalVerificacaoDto updateNotaFiscalVerificacao(Long notaFiscalVerificacaoId, NotaFiscalVerificacaoDto updatedNotaFiscalVerificacao);

    void deleteNotaFiscalVerificacao(Long notaFiscalVerificacaoId);
}
