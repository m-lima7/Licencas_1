package br.com.fiap.Alertas.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class TratadorDeExceptions {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> tratarErro404() {
        return ResponseEntity.status(404).body("Recurso não encontrado");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> tratarErro500(Exception e) {
        return ResponseEntity.status(500).body("Erro interno: " + e.getMessage());
    }

}
