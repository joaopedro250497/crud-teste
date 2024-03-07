package net.javaguides.rmsbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotaFiscalVerificacaoDto {
    private Long id;
    private String dataVerificacao;
    private Byte xml;
}
