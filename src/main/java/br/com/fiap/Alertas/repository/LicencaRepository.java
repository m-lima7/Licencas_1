package br.com.fiap.Alertas.repository;


import br.com.fiap.Alertas.model.Licenca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LicencaRepository extends JpaRepository<Licenca, Long> {
    //List<Licenca> findByData_validadeBetweenAndStatusNot(LocalDate start, LocalDate end, StatusLicenca status);

}
