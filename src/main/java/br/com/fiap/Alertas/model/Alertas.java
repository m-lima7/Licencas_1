package br.com.fiap.Alertas.model;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "t_alertas")
public class Alertas {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ALERTAS_SEQ"
    )
    @SequenceGenerator(
            name = "ALERTAS_SEQ",
            sequenceName = "ALERTAS_SEQ",
            allocationSize = 1
    )
    @Column(name = "id_alerta")
    private Long idAlerta;

    @JoinColumn(name = "id_licenca")
    private Long idLicenca;

    @Column(name = "data_alerta")
    private LocalDate dataAlerta;
    @Column(length = 200)
    private String mensagem;
    private char enviado;

    public Alertas(){}

    public Alertas(Long id_alerta, Long id_licenca, LocalDate data_alerta, String mensagem, char enviado) {
        this.idAlerta = id_alerta;
        this.idLicenca = id_licenca;
        this.dataAlerta = data_alerta;
        this.mensagem = mensagem;
        this.enviado = enviado;
    }

    public Long getIdAlerta() {
        return idAlerta;
    }

    public void setIdAlerta(Long id_alerta) {
        this.idAlerta = id_alerta;
    }

    public Long getIdLicenca() {
        return idLicenca;
    }

    public void setIdLicenca(Long id_licenca) {
        this.idLicenca = id_licenca;
    }

    public LocalDate getDataAlerta() {
        return dataAlerta;
    }

    public void setDataAlerta(LocalDate data_alerta) {
        this.dataAlerta = data_alerta;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public char getEnviado() {
        return enviado;
    }

    public void setEnviado(char enviado) {
        this.enviado = enviado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alertas alertas = (Alertas) o;
        return enviado == alertas.enviado && Objects.equals(idAlerta, alertas.idAlerta) && Objects.equals(idLicenca, alertas.idLicenca) && Objects.equals(dataAlerta, alertas.dataAlerta) && Objects.equals(mensagem, alertas.mensagem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAlerta, idLicenca, dataAlerta, mensagem, enviado);
    }

    @Override
    public String toString() {
        return "Alertas{" +
                "id_alerta=" + idAlerta +
                ", id_licenca=" + idLicenca +
                ", data_alerta=" + dataAlerta +
                ", mensagem='" + mensagem + '\'' +
                ", enviado=" + enviado +
                '}';
    }
}
