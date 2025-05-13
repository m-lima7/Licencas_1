package br.com.fiap.Alertas.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "licencas")
public class Licenca {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "LICENCA_SEQ")
    @SequenceGenerator(name="LICENCA_SEQ", sequenceName = "SEQ_LICENCA", allocationSize=1)
    @Column(name="id_licenca")
    private Long idLicenca;
    @JoinColumn(name = "id_empresa")
    private Long empresa;
    private Long id_tipo;
    private LocalDate data_emissao;
    private LocalDate data_validade;
    @Column(length = 20)
    private StatusLicenca status;

    public Licenca() {
    }

    public Licenca(Long id_licenca, Long empresa, Long id_tipo, LocalDate data_emissao, LocalDate data_validade, StatusLicenca status) {
        this.idLicenca = id_licenca;
        this.empresa = empresa;
        this.id_tipo = id_tipo;
        this.data_emissao = data_emissao;
        this.data_validade = data_validade;
        this.status = status;
    }


    public Long getIdLicenca() {
        return idLicenca;
    }

    public void setIdLicenca(Long id_licenca) {
        this.idLicenca = id_licenca;
    }

    public Long getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Long empresa) {
        this.empresa = empresa;
    }

    public Long getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(Long id_tipo) {
        this.id_tipo = id_tipo;
    }

    public LocalDate getData_emissao() {
        return data_emissao;
    }

    public void setData_emissao(LocalDate data_emissao) {
        this.data_emissao = data_emissao;
    }

    public LocalDate getData_validade() {
        return data_validade;
    }

    public void setData_validade(LocalDate data_validade) {
        this.data_validade = data_validade;
    }

    public StatusLicenca getStatus() {
        return status;
    }

    public void setStatus(StatusLicenca status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Licenca licenca = (Licenca) o;
        return Objects.equals(idLicenca, licenca.idLicenca) && Objects.equals(empresa, licenca.empresa) && Objects.equals(id_tipo, licenca.id_tipo) && Objects.equals(data_emissao, licenca.data_emissao) && Objects.equals(data_validade, licenca.data_validade) && status == licenca.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLicenca, empresa, id_tipo, data_emissao, data_validade, status);
    }

    @Override
    public String toString() {
        return "Licenca{" +
                "id_licenca=" + idLicenca +
                ", empresa=" + empresa +
                ", id_tipo=" + id_tipo +
                ", data_emissao=" + data_emissao +
                ", data_validade=" + data_validade +
                ", status=" + status +
                '}';
    }
}
