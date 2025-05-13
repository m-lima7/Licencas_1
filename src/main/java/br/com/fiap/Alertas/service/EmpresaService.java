package br.com.fiap.Alertas.service;

import br.com.fiap.Alertas.model.Empresa;
import br.com.fiap.Alertas.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public List<Empresa> listaEmpresas(){
        return empresaRepository.findAll();
    }
    public Empresa buscaEmpresa(Long id){
        return empresaRepository.findById(id).get();
    }

    public Empresa criarEmpresa(Empresa empresa){
        return empresaRepository.save(empresa);
    }
    public Empresa atualizarEmpresa( Long id, Empresa empresa){
        Empresa emp = buscaEmpresa(id);
        if(emp != null){
            emp.setCnpj(empresa.getCnpj());
            emp.setNomeEmpresa(empresa.getNomeEmpresa());
        }
        return empresaRepository.save(empresa);
    }

    public void deleteEmpresa(Long id) {
        Empresa empresa = buscaEmpresa(id);
        empresaRepository.delete(empresa);
    }
}
