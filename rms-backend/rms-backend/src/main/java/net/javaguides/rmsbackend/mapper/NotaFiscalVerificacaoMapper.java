package net.javaguides.rmsbackend.mapper;

import net.javaguides.rmsbackend.dto.NotaFiscalVerificacaoDto;
import net.javaguides.rmsbackend.entity.NotaFiscalVerificacao;

public class NotaFiscalVerificacaoMapper {

    public static NotaFiscalVerificacaoDto mapToNotaFiscalVerificacaoDto(NotaFiscalVerificacao notaFiscalVerificacao){
        return new NotaFiscalVerificacaoDto(
                notaFiscalVerificacao.getId(),
                notaFiscalVerificacao.getDataVerificacao(),
                notaFiscalVerificacao.getXml()
        );
    }

    public static NotaFiscalVerificacao mapToNotaFiscalVerificacao(NotaFiscalVerificacaoDto notaFiscalVerificacaoDto){
        return new NotaFiscalVerificacao(
                notaFiscalVerificacaoDto.getId(),
                notaFiscalVerificacaoDto.getDataVerificacao(),
                notaFiscalVerificacaoDto.getXml()
        );
    }
}
