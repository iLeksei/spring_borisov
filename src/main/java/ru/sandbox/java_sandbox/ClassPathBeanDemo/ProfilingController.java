package ru.sandbox.java_sandbox.ClassPathBeanDemo;

public class ProfilingController implements ProfilingControllerMBean {
  private boolean enabled;

  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }
}
