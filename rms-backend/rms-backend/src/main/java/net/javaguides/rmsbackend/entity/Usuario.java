package net.javaguides.rmsbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf", nullable = false)
    private String cpf;

    @Column(name = "ativo")
    private Boolean ativo;

    @Column(name = "administrador")
    private Boolean administrador;

    @Column(name = "data_registro")
    private String dataRegistro;

    @Column(name = "data_bloqueio", nullable = false)
    private String dataBloqueio;

}