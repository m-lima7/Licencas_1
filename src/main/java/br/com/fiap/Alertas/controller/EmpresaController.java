package br.com.fiap.Alertas.controller;

import br.com.fiap.Alertas.model.Empresa;
import br.com.fiap.Alertas.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;


    @GetMapping
    public ResponseEntity<List<Empresa>> getAll(){
        return ResponseEntity.ok(empresaService.listaEmpresas());
    }

    @GetMapping("/{id}")
    public Empresa getById(@PathVariable long id){
        return empresaService.buscaEmpresa(id);
    }

    @PostMapping
    public ResponseEntity<Empresa> criaEmpresa(@RequestBody Empresa empresa){
        Empresa createdempresa = empresaService.criarEmpresa(empresa);
        return ResponseEntity.ok().body(createdempresa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empresa> alteraEmpresa(
            @PathVariable Long id,
            @RequestBody Empresa empresa){
        Empresa emp = empresaService.buscaEmpresa(id);
        empresaService.atualizarEmpresa(id,emp);
        return ResponseEntity.ok().body(emp);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmpresa(@PathVariable Long id){
        empresaService.deleteEmpresa(id);
        return ResponseEntity.noContent().build();
    }
}
