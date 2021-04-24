package ru.sandbox.java_sandbox.CustomContextDemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
  public static void main(String[] args) throws InterruptedException {
    PropertyFileApplicationContext context = new PropertyFileApplicationContext("context.properties");

    while (true) {
      Thread.sleep(2000);
      context.getBean(Quoter.class).sayQuote();
    }

  }
}
