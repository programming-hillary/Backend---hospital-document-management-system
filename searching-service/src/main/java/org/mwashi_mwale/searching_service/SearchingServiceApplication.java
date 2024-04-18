package org.mwashi_mwale.searching_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("org.mwashi_mwale.searching_service.repository")
public class SearchingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SearchingServiceApplication.class, args);
    }

}
