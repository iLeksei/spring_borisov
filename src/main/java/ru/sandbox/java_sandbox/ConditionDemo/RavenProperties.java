package ru.sandbox.java_sandbox.ConditionDemo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Data
@ConfigurationProperties("raven")
@Configuration
public class RavenProperties {
  List<String> where;
}
