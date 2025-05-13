//package br.com.fiap.Alertas;
//
//import org.flywaydb.core.Flyway;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class FlywayCleaner implements CommandLineRunner {
//
//    @Autowired
//    private Flyway flyway;
//
//    @Override
//    public void run(String... args) throws Exception {
//        // ⚠️ CUIDADO: Isso apaga o schema inteiro
//        flyway.clean();
//        System.out.println("Banco de dados limpo com sucesso!");
//    }
//}
