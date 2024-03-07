package net.javaguides.rmsbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotaFiscalDto {
    private Long id;
    private String situacao;
    private String dataLancamento;
    private String dataEmissao;
    private String dataCancelamento;
    private String chave;
    private Long numero;
    private Float valorTotal;
    private Float quantidadeTotal;
    private String naturezaOperacao;
    private String tipoOperacao;
    private Long modelo;
    private Long serie;
    private String verificadorCentralId;
    private String situacaoVerificadorCentral;
    private String dataEnvioVerificadorCentral;
}
