package br.com.fiap.Alertas.service;

import br.com.fiap.Alertas.model.Licenca;
import br.com.fiap.Alertas.model.StatusLicenca;
import br.com.fiap.Alertas.repository.LicencaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class LicencaService {

    @Autowired
    private LicencaRepository licencaRepository;

    public Licenca createLicenca(Licenca licenca) {
        return licencaRepository.save(licenca);
    }

    public Licenca saveLicenca(Licenca licenca) {
        return licencaRepository.save(licenca);
    }


    public Licenca getLicencaById(Long id) {
        Optional<Licenca> optionalLicenca = licencaRepository.findById(id);
        return optionalLicenca.orElseThrow(() -> new RuntimeException("Licença não encontrada com ID: " + id));
    }

    public List<Licenca> listAllLicencas() {
        return licencaRepository.findAll();
    }

    public Licenca updateLicenca(Long id, Licenca updatedLicenca) {
        Licenca licenca = getLicencaById(id);

        licenca.setData_emissao(updatedLicenca.getData_emissao());
        licenca.setData_validade(updatedLicenca.getData_validade());
        licenca.setStatus(updatedLicenca.getStatus());
        licenca.setEmpresa(updatedLicenca.getEmpresa());
        licenca.setId_tipo(updatedLicenca.getId_tipo());

        return licencaRepository.save(licenca);
    }

    public void deleteLicenca(Long id) {
        Licenca licenca = getLicencaById(id);
        licencaRepository.delete(licenca);
    }


    public StatusLicenca atualizarStatus(Licenca licenca) {
        LocalDate hoje = LocalDate.now();

        if (licenca.getStatus() == StatusLicenca.CANCELADA) {
            return StatusLicenca.CANCELADA;
        }
        //FALTA PENDENTE
        if (licenca.getData_validade() == null || licenca.getData_emissao() == null) {
            licenca.setStatus(StatusLicenca.SEM_LICENCA);
        } else if (licenca.getData_validade().isBefore(hoje)) {
            licenca.setStatus(StatusLicenca.EXPIRADA);
        } else {
            licenca.setStatus(StatusLicenca.ATIVA);
        }

        licencaRepository.save(licenca);
        return licenca.getStatus();
    }

    public List<Licenca> findLicencasExpiringSoon()
    {
        LocalDate today = LocalDate.now();
        LocalDate in7Days = today.plusDays(7);
//        return licencaRepository.findByData_validadeBetweenAndStatusNot(today, in7Days, StatusLicenca.EXPIRADA);
        return null;
    }
    public LocalDate renovarValidade(Licenca licenca) {
        LocalDate novaDataValidade = licenca.getData_validade().plusYears(1);
        licenca.setData_validade(novaDataValidade);

        atualizarStatus(licenca);

        licencaRepository.save(licenca);

        return novaDataValidade;
    }

}
