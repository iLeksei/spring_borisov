package ru.sandbox.java_sandbox.BeanLifecycleDemo;

import com.sun.istack.internal.Nullable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Slf4j
//@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BeanLifecycleDemo {

  @InjectRandomInt(min = 1, max = 10)
  private int randomValue;

  @Override
  public String toString() {
    return "my random value: " + randomValue;
  }
}
