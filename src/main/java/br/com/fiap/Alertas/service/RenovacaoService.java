package br.com.fiap.Alertas.service;

import br.com.fiap.Alertas.model.Licenca;
import br.com.fiap.Alertas.model.Renovacoes;
import br.com.fiap.Alertas.model.StatusLicenca;
import br.com.fiap.Alertas.repository.RenovacoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class RenovacaoService {

    @Autowired
    private RenovacoesRepository renovacoesRepository;

    @Autowired
    private LicencaService licencaService;

    public Renovacoes createRenewal(Long licencaId) {
        Licenca licenca = licencaService.getLicencaById(licencaId);

        if (licenca.getStatus() != StatusLicenca.ATIVA) {
            throw new RuntimeException("Licença não está ativa para renovação.");
        }

        LocalDate newExpiration = licencaService.renovarValidade(licenca);

        Renovacoes renovacao = new Renovacoes();
        renovacao.setId_licenca(licenca);
        renovacao.setData_renovacao(LocalDate.now());
        renovacao.setNova_data_renovacao(newExpiration);

        return renovacoesRepository.save(renovacao);
    }
}
