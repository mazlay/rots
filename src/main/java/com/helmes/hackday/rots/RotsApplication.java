package com.helmes.hackday.rots;

import com.helmes.hackday.rots.config.RotsConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@Import(RotsConfig.class)
public class RotsApplication {

  public static void main(String[] args) {
    SpringApplication.run(RotsApplication.class, args);
  }
}
