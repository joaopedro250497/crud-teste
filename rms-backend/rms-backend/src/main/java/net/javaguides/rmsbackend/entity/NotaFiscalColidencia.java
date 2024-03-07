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
@Table(name = "nota_fiscal_colidencia")
public class NotaFiscalColidencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "situacao")
    private String situacao;

    @Column(name = "data_ocorrencia")
    private String dataOcorrencia;

    @Column(name = "data_resolucao", nullable = false)
    private String dataResolucao;

    @Column(name = "observacao", nullable = false)
    private String observacao;

}
