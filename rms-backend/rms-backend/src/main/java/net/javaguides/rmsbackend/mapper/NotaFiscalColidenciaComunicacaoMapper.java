package net.javaguides.rmsbackend.mapper;

import net.javaguides.rmsbackend.dto.EmpresaDto;
import net.javaguides.rmsbackend.dto.NotaFiscalColidenciaComunicacaoDto;
import net.javaguides.rmsbackend.entity.Empresa;
import net.javaguides.rmsbackend.entity.NotaFiscalColidenciaComunicacao;

public class NotaFiscalColidenciaComunicacaoMapper {

    public static NotaFiscalColidenciaComunicacaoDto mapToNotaFiscalColidenciaComunicacaoDto(NotaFiscalColidenciaComunicacao notaFiscalColidenciaComunicacao){
        return new NotaFiscalColidenciaComunicacaoDto(
                notaFiscalColidenciaComunicacao.getId(),
                notaFiscalColidenciaComunicacao.getDataOcorrencia(),
                notaFiscalColidenciaComunicacao.getObservacao()
        );
    }

    public static NotaFiscalColidenciaComunicacao mapToNotaFiscalColidenciaComunicacao(NotaFiscalColidenciaComunicacaoDto notaFiscalColidenciaComunicacaoDto){
        return new NotaFiscalColidenciaComunicacao(
                notaFiscalColidenciaComunicacaoDto.getId(),
                notaFiscalColidenciaComunicacaoDto.getDataOcorrencia(),
                notaFiscalColidenciaComunicacaoDto.getObservacao()
        );
    }
}
