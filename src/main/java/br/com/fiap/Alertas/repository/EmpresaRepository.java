package br.com.fiap.Alertas.repository;

import br.com.fiap.Alertas.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}
