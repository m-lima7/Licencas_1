package br.com.fiap.Alertas.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "renovacoes")
public class Renovacoes {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "RENOVACAO_SEQ")
    @SequenceGenerator(name="RENOVACAO_SEQ", sequenceName = "SEQ_RENOVACAO", allocationSize=1)
    @Column(name="id_renovacao")
    private Long id_renovacao;
    @ManyToOne
    @JoinColumn(name = "id_licenca")
    private Licenca id_licenca;
    private LocalDate data_renovacao;
    private LocalDate nova_data_renovacao;

    public Renovacoes() {}
    public Renovacoes(Long id_renovacao, Licenca id_licenca, LocalDate data_renovacao, LocalDate nova_data_renovacao) {
        this.id_renovacao = id_renovacao;
        this.id_licenca = id_licenca;
        this.data_renovacao = data_renovacao;
        this.nova_data_renovacao = nova_data_renovacao;
    }

    public Long getId_renovacao() {
        return id_renovacao;
    }

    public void setId_renovacao(Long id_renovacao) {
        this.id_renovacao = id_renovacao;
    }

    public LocalDate getData_renovacao() {
        return data_renovacao;
    }

    public void setData_renovacao(LocalDate data_renovacao) {
        this.data_renovacao = data_renovacao;
    }

    public LocalDate getNova_data_renovacao() {
        return nova_data_renovacao;
    }

    public void setNova_data_renovacao(LocalDate nova_data_renovacao) {
        this.nova_data_renovacao = nova_data_renovacao;
    }

    public Licenca getId_licenca() {
        return id_licenca;
    }

    public void setId_licenca(Licenca id_licenca) {
        this.id_licenca = id_licenca;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Renovacoes that = (Renovacoes) o;
        return Objects.equals(id_renovacao, that.id_renovacao) && Objects.equals(id_licenca, that.id_licenca) && Objects.equals(data_renovacao, that.data_renovacao) && Objects.equals(nova_data_renovacao, that.nova_data_renovacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_renovacao, id_licenca, data_renovacao, nova_data_renovacao);
    }

    @Override
    public String toString() {
        return "Renovacoes{" +
                "id_renovacao=" + id_renovacao +
                ", id_licenca=" + id_licenca +
                ", data_renovacao=" + data_renovacao +
                ", nova_data_renovacao=" + nova_data_renovacao +
                '}';
    }
}
