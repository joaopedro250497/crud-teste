package net.javaguides.rmsbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {
    private Long id;
    private String email;
    private String nome;
    private String cpf;
    private Boolean ativo;
    private Boolean administrador;
    private String dataRegistro;
    private String dataBloqueio;
}
