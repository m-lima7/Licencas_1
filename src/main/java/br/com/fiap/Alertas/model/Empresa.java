package br.com.fiap.Alertas.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "t_empresas")
public class Empresa {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "EMPRESAS_SEQ"
    )
    @SequenceGenerator(
            name = "EMPRESAS_SEQ",
            sequenceName = "EMPRESAS_SEQ",
            allocationSize = 1
    )
    @Column(name = "id_empresa")
    private Long idEmpresa;
    @Column(length = 100)
    private String nomeEmpresa;
    @Column(length = 18)
    private String cnpj;

    public Empresa() {
    }

    public Empresa(Long empresa_id, String nomeEmpresa, String cnpj) {
        this.idEmpresa = empresa_id;
        this.nomeEmpresa = nomeEmpresa;
        this.cnpj = cnpj;
    }

    public Long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Long empresa_id) {
        this.idEmpresa = empresa_id;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nome_empresa) {
        this.nomeEmpresa = nome_empresa;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empresa empresa = (Empresa) o;
        return Objects.equals(idEmpresa, empresa.idEmpresa) && Objects.equals(nomeEmpresa, empresa.nomeEmpresa) && Objects.equals(cnpj, empresa.cnpj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEmpresa, nomeEmpresa, cnpj);
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "idEmpresa=" + idEmpresa +
                ", nomeEmpresa='" + nomeEmpresa + '\'' +
                ", cnpj='" + cnpj + '\'' +
                '}';
    }
}

