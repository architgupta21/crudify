package com.vortex.crudify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication
public class CrudifyApplication {

    public static void main(String[] args) {

        SpringApplication.run(CrudifyApplication.class, args);
        System.out.println("CrudifyApplication started");
    }

}
