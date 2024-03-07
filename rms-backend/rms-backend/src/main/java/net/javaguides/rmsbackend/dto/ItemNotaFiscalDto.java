package net.javaguides.rmsbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemNotaFiscalDto {
    private Long id;
    private String quantidade;
    private Float valorUnitario;
    private Float valorProduto;
}
