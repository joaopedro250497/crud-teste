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
@Table(name = "nota_fiscal_colidencia_comunicacao")
public class NotaFiscalColidenciaComunicacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_ocorrencia")
    private String dataOcorrencia;

    @Column(name = "observacao")
    private String observacao;

}