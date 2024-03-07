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
@Table(name = "nota_fiscal")
public class NotaFiscal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "situacao", nullable = false)
    private String situacao;

    @Column(name = "data_lancamento")
    private String dataLancamento;

    @Column(name = "data_emissao")
    private String dataEmissao;

    @Column(name = "data_cancelamento")
    private String dataCancelamento;

    @Column(name = "chave")
    private String chave;

    @Column(name = "numero")
    private Long numero;

    @Column(name = "valor_total")
    private Float valorTotal;

    @Column(name = "quantidade_total")
    private Float quantidadeTotal;

    @Column(name = "natureza_operacao")
    private String naturezaOperacao;

    @Column(name = "tipo_operacao")
    private String tipoOperacao;

    @Column(name = "modelo")
    private Long modelo;

    @Column(name = "serie")
    private Long serie;

    @Column(name = "verificador_central_id", nullable = false)
    private String verificadorCentralId;

    @Column(name = "situacao_verificador_central", nullable = false)
    private String situacaoVerificadorCentral;

    @Column(name = "data_envio_verificador_central", nullable = false)
    private String dataEnvioVerificadorCentral;

}
