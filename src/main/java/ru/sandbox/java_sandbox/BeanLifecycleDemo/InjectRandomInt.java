package ru.sandbox.java_sandbox.BeanLifecycleDemo;

import org.springframework.lang.Nullable;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.LOCAL_VARIABLE, ElementType.FIELD, ElementType.PARAMETER})
public @interface InjectRandomInt {
  int min() default 0;

  int max() default 10;
}
