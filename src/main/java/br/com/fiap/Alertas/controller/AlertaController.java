package br.com.fiap.Alertas.controller;

import br.com.fiap.Alertas.model.Alertas;
import br.com.fiap.Alertas.service.AlertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alertas")
public class AlertaController {

    @Autowired
    private AlertaService alertaService;

    @PostMapping
    public ResponseEntity<Alertas> create(@RequestBody Alertas alerta) {
        return ResponseEntity.status(201).body(alertaService.createAlerta(alerta));
    }

    @GetMapping
    public ResponseEntity<List<Alertas>> findAll() {
        return ResponseEntity.ok(alertaService.getAllAlertas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alertas> findById(@PathVariable Long id) {
        return ResponseEntity.ok(alertaService.getAlertaById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alertas> update(@PathVariable Long id, @RequestBody Alertas alerta) {
        return ResponseEntity.ok(alertaService.updateAlerta(id, alerta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        alertaService.deleteAlerta(id);
        return ResponseEntity.noContent().build();
    }

}
