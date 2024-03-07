package net.javaguides.rmsbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotaFiscalColidenciaDto {
    private Long id;
    private String situacao;
    private String dataOcorrencia;
    private String dataResolucao;
    private String observacao;
}
