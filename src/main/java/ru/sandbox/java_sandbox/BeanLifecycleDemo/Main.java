package ru.sandbox.java_sandbox.BeanLifecycleDemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
public class Main {
  public static void main(String[] args) {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
    LOG.info(context.getBean("beanLifecycleDemo").toString());
  }
}
