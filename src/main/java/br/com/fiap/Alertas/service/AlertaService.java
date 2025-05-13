package br.com.fiap.Alertas.service;


import br.com.fiap.Alertas.model.Alertas;
import br.com.fiap.Alertas.repository.AlertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertaService {

    @Autowired
    private AlertaRepository alertasRepository;

    public Alertas createAlerta(Alertas alerta) {
        return alertasRepository.save(alerta);
    }

    public List<Alertas> getAllAlertas() {
        return alertasRepository.findAll();
    }

    public Alertas getAlertaById(Long id) {
        return alertasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alerta com ID " + id + " não encontrado"));
    }

    public Alertas updateAlerta(Long id, Alertas updatedAlerta) {
        Alertas alerta = getAlertaById(id);

        alerta.setIdLicenca(updatedAlerta.getIdLicenca());
        alerta.setDataAlerta(updatedAlerta.getDataAlerta());
        alerta.setMensagem(updatedAlerta.getMensagem());
        alerta.setEnviado(updatedAlerta.getEnviado());

        return alertasRepository.save(alerta);
    }

    public void deleteAlerta(Long id) {
        alertasRepository.deleteById(id);
    }

}
