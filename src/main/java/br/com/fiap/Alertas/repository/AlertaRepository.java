package br.com.fiap.Alertas.repository;

import br.com.fiap.Alertas.model.Alertas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertaRepository extends JpaRepository<Alertas, Long> {
}
