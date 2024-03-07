package net.javaguides.rmsbackend.mapper;

import net.javaguides.rmsbackend.dto.NotaFiscalColidenciaDto;
import net.javaguides.rmsbackend.entity.NotaFiscalColidencia;

public class NotaFiscalColidenciaMapper {

    public static NotaFiscalColidenciaDto mapToNotaFiscalColidenciaDto(NotaFiscalColidencia notaFiscalColidencia){
        return new NotaFiscalColidenciaDto(
                notaFiscalColidencia.getId(),
                notaFiscalColidencia.getSituacao(),
                notaFiscalColidencia.getDataOcorrencia(),
                notaFiscalColidencia.getDataResolucao(),
                notaFiscalColidencia.getObservacao()
        );
    }

    public static NotaFiscalColidencia mapToNotaFiscalColidencia(NotaFiscalColidenciaDto notaFiscalColidenciaDto){
        return new NotaFiscalColidencia(
                notaFiscalColidenciaDto.getId(),
                notaFiscalColidenciaDto.getSituacao(),
                notaFiscalColidenciaDto.getDataOcorrencia(),
                notaFiscalColidenciaDto.getDataResolucao(),
                notaFiscalColidenciaDto.getObservacao()
        );
    }
}
