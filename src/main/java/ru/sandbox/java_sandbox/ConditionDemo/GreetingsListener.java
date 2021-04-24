package ru.sandbox.java_sandbox.ConditionDemo;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class GreetingsListener implements ApplicationListener<ContextRefreshedEvent> {
  @Override
  public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    System.out.println("hello user!!! Application has been started!!!");
  }
}
