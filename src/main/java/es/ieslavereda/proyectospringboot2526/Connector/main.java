package es.ieslavereda.proyectospringboot2526.Connector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("es.ieslavereda.proyectospringboot2526.repository.model")
public class main {

    public static void main(String[] args) {
        SpringApplication.run(main.class, args);
    }
}
