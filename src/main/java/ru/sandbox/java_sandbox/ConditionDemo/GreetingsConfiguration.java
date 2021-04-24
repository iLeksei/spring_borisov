package ru.sandbox.java_sandbox.ConditionDemo;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(RavenProperties.class)
public class GreetingsConfiguration {

  @Bean
  @ConditionOnProduction
  @ConditionalOnProperty("raven.where")
  public GreetingsListener greetingsListener() {
    return new GreetingsListener();
  }

}
