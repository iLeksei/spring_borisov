package ru.sandbox.java_sandbox.BFactoryPostProcessorDemo;

import lombok.extern.slf4j.Slf4j;
import ru.sandbox.java_sandbox.ClassPathBeanDemo.TerminatorQuoterImpl;

@Slf4j
public class SuperTerminator extends TerminatorQuoterImpl {
  @Override
  public void sayQuote() {
    LOG.info("i'm super terminator!");
  }
}
