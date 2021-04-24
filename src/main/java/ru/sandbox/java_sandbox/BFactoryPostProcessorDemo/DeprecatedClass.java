package ru.sandbox.java_sandbox.BFactoryPostProcessorDemo;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
public @interface DeprecatedClass {
  Class newImpl();
}
