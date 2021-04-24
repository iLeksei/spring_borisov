package ru.sandbox.java_sandbox.ApplicationListenerDemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class ProfilingAnnotationBeanPostProcessor implements BeanPostProcessor {

  public ProfilingAnnotationBeanPostProcessor() throws Exception {
    MBeanServer platformMBeanServer = ManagementFactory.getPlatformMBeanServer(); // for registration in mbean
    platformMBeanServer.registerMBean(controller, new ObjectName("profiling", "name", "controller"));
  }

  /**
   * map for collect original classes, before using Proxy
   * need for change our class on runtime
   */
  private Map<String, Class> profilingClasses = new HashMap<>();

  /**
   * need for trigger profiling
   */
  private ProfilingController controller = new ProfilingController();

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
    Class<?> beanClass = bean.getClass();
    if (beanClass.isAnnotationPresent(Profiling.class)) {
      profilingClasses.put(beanName, beanClass);
    }

    return bean;
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    Class profilingBean = profilingClasses.get(beanName);
    if (profilingBean != null) {
      return Proxy.newProxyInstance(
              profilingBean.getClassLoader(),
              profilingBean.getInterfaces(),
              new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                  if (controller.isEnabled()) {
                    LOG.info("Profiling...");
                    long before = System.nanoTime();
                    Object returnedValue = method.invoke(bean, args); // all methods in beans
                    long after = System.nanoTime();
                    LOG.info("Profiling done! result: {}", before - after);
                    return returnedValue;
                  } else {
                    return method.invoke(bean, args);
                  }
                }
              }
      );
    }

    return bean;
  }
}
