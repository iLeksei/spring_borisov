package ru.sandbox.java_sandbox.CustomContextDemo;

import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

@Slf4j
public class PropertyFileApplicationContext extends GenericApplicationContext {
  public PropertyFileApplicationContext(String fileName) {
    PropertiesBeanDefinitionReader reader = new PropertiesBeanDefinitionReader(this);
    int beansCount = reader.loadBeanDefinitions(fileName);
    LOG.info("found: {} beans", beansCount);
    refresh();
  }
}
