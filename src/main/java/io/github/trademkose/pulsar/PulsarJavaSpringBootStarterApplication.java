package io.github.trademkose.pulsar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class PulsarJavaSpringBootStarterApplication {
    public static void main(String[] args) {
        SpringApplication.run(PulsarJavaSpringBootStarterApplication.class, args);
    }
}
