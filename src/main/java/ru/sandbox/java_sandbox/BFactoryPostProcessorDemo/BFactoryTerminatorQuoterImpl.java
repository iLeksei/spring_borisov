package ru.sandbox.java_sandbox.BFactoryPostProcessorDemo;

import lombok.extern.slf4j.Slf4j;
import ru.sandbox.java_sandbox.BeanLifecycleDemo.InjectRandomInt;

import javax.annotation.PostConstruct;

@Slf4j
@Profiling
@DeprecatedClass(newImpl = SuperTerminator.class)
public class BFactoryTerminatorQuoterImpl implements Quoter {

  public void setMessage(String message) {
    this.message = message;
  }

  public BFactoryTerminatorQuoterImpl() {
    System.out.println("phase 1 constructor: " + this.getClass().getSimpleName());
  }

  @PostConstruct
  public void init() {
    System.out.println("phase 2 initialization: " + this.getClass().getSimpleName());
  }

  @InjectRandomInt(min = 1, max = 5)
  private int repeat;

  private String message = "I'll be back!!!";

  @Override
  public void sayQuote() {
    int count = 0;
    while (count <= repeat) {
      ++count;
      System.out.println("My message: " + this.message);
    }
  }
}
