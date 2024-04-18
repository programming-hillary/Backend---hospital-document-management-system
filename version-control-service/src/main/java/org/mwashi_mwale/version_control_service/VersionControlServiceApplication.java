package org.mwashi_mwale.version_control_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("org.mwashi_mwale.version_control_service.repository")
public class VersionControlServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(VersionControlServiceApplication.class, args);
    }
}
