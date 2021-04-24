package ru.sandbox.java_sandbox.ConditionDemo;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Conditional({CheckProduction.class})
public @interface ConditionOnProduction {
}
