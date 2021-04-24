package ru.sandbox.java_sandbox.ApplicationListenerDemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
  public static void main(String[] args) {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
  }
}
