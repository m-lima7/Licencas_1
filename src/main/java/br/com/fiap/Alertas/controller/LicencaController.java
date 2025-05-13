package br.com.fiap.Alertas.controller;

import br.com.fiap.Alertas.model.Empresa;
import br.com.fiap.Alertas.model.Licenca;
import br.com.fiap.Alertas.model.Renovacoes;
import br.com.fiap.Alertas.model.StatusLicenca;
import br.com.fiap.Alertas.service.EmpresaService;
import br.com.fiap.Alertas.service.LicencaService;
import br.com.fiap.Alertas.service.RenovacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/licencas")
public class LicencaController {

    @Autowired
    private LicencaService licencaService;

    @Autowired
    private RenovacaoService renovacaoService;

    @Autowired
    private EmpresaService empresaService;

    @PostMapping
    public ResponseEntity<Licenca> createLicenca(@RequestBody Licenca licenca) {
        if (licenca.getEmpresa() == null || licenca.getEmpresa() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID da empresa é obrigatório.");
        }

        Long empresaId = licenca.getEmpresa();
        Empresa empresa = empresaService.buscaEmpresa(empresaId);

        if (empresa == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Empresa com ID " + empresaId + " não encontrada.");
        }

        // Replace the transient Empresa with the managed one
        licenca.setEmpresa(empresaId);

        try {
            Licenca createdLicenca = licencaService.createLicenca(licenca);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdLicenca);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao criar Licença: " + e.getMessage(), e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Licenca> getLicencaById(@PathVariable Long id) {
        Licenca licenca = licencaService.getLicencaById(id);
        return ResponseEntity.ok(licenca);
    }

    @GetMapping
    public ResponseEntity<List<Licenca>> listAllLicencas() {
        List<Licenca> licencas = licencaService.listAllLicencas();
        return ResponseEntity.ok(licencas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Licenca> updateLicenca(@PathVariable Long id, @RequestBody Licenca updatedLicenca) {
        Licenca licenca = licencaService.updateLicenca(id, updatedLicenca);
        return ResponseEntity.ok(licenca);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLicenca(@PathVariable Long id) {
        licencaService.deleteLicenca(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<StatusLicenca> updateLicencaStatus(@PathVariable Long id) {
        Licenca licenca = licencaService.getLicencaById(id);
        StatusLicenca status = licencaService.atualizarStatus(licenca);
        return ResponseEntity.ok(status);
    }

    @GetMapping("/expiring-soon")
    public ResponseEntity<List<Licenca>> findLicencasExpiringSoon() {
        List<Licenca> licencas = licencaService.findLicencasExpiringSoon();
        return ResponseEntity.ok(licencas);
    }

    @PostMapping("/{id}/renovar")
    public ResponseEntity<?> renovarLicenca(@PathVariable Long id) {
        try {
            Renovacoes renovacao = renovacaoService.createRenewal(id);
            return ResponseEntity.ok(renovacao);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
