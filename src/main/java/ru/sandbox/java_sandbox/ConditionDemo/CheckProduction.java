package ru.sandbox.java_sandbox.ConditionDemo;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import javax.swing.*;

public class CheckProduction implements Condition {
  @Override
  public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
//    return true;
    System.setProperty("java.awt.headless", "false");
    return JOptionPane.showConfirmDialog(null, "где я? это продакшн?", "is it prod?", JOptionPane.YES_NO_CANCEL_OPTION) == 0;
  }
}
