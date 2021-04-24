package ru.raven;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RavenConfiguration {

  @Bean
  public RavenListener ravenListener() {
    return new RavenListener();
  }

}
