package ru.sandbox.java_sandbox.ApplicationListenerDemo;

/**
 * need for jmx console
 * this method can be using in jmx console
 */
public interface ProfilingControllerMBean {
  void setEnabled(boolean enabled);
}
