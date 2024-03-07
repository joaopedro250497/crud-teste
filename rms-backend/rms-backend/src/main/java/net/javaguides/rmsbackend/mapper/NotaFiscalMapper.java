package net.javaguides.rmsbackend.mapper;

import net.javaguides.rmsbackend.dto.NotaFiscalDto;
import net.javaguides.rmsbackend.entity.NotaFiscal;

public class NotaFiscalMapper {

    public static NotaFiscalDto mapToNotaFiscalDto(NotaFiscal notaFiscal){
        return new NotaFiscalDto(
                notaFiscal.getId(),
                notaFiscal.getSituacao(),
                notaFiscal.getDataLancamento(),
                notaFiscal.getDataEmissao(),
                notaFiscal.getDataCancelamento(),
                notaFiscal.getChave(),
                notaFiscal.getNumero(),
                notaFiscal.getValorTotal(),
                notaFiscal.getQuantidadeTotal(),
                notaFiscal.getNaturezaOperacao(),
                notaFiscal.getTipoOperacao(),
                notaFiscal.getModelo(),
                notaFiscal.getSerie(),
                notaFiscal.getVerificadorCentralId(),
                notaFiscal.getSituacaoVerificadorCentral(),
                notaFiscal.getDataEnvioVerificadorCentral()
        );
    }

    public static NotaFiscal mapToNotaFiscal(NotaFiscalDto notaFiscalDto){
        return new NotaFiscal(
                notaFiscalDto.getId(),
                notaFiscalDto.getSituacao(),
                notaFiscalDto.getDataLancamento(),
                notaFiscalDto.getDataEmissao(),
                notaFiscalDto.getDataCancelamento(),
                notaFiscalDto.getChave(),
                notaFiscalDto.getNumero(),
                notaFiscalDto.getValorTotal(),
                notaFiscalDto.getQuantidadeTotal(),
                notaFiscalDto.getNaturezaOperacao(),
                notaFiscalDto.getTipoOperacao(),
                notaFiscalDto.getModelo(),
                notaFiscalDto.getSerie(),
                notaFiscalDto.getVerificadorCentralId(),
                notaFiscalDto.getSituacaoVerificadorCentral(),
                notaFiscalDto.getDataEnvioVerificadorCentral()
        );
    }
}
