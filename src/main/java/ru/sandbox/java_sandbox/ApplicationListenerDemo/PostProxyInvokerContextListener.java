package ru.sandbox.java_sandbox.ApplicationListenerDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.lang.reflect.Method;

public class PostProxyInvokerContextListener implements ApplicationListener<ContextRefreshedEvent> {

  @Autowired
  private ConfigurableListableBeanFactory factory;

  /**
   * после настройки контеста и определения всех пинов идет событие ContextRefreshedEvent
   * тут мы и запускаем метод из уже настроенного бина, который ищем в контесксте по исходному имени бина
   */
  @Override
  public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    ApplicationContext context = contextRefreshedEvent.getApplicationContext();
    String[] names = context.getBeanDefinitionNames();
    for (String name : names) {
      // достаем бин-дифинишены, а не настроеные бины
      // т.к. не надо трогать уже настроенные бины или бины singleton-lazy
      BeanDefinition beanDefinition = factory.getBeanDefinition(name);
      String originalClassName = beanDefinition.getBeanClassName();
      try {
        //теперь достаем уже настроенный (или нет) класс и вызываем его метод
        Class<?> originalClass = Class.forName(originalClassName);
        Method[] methods = originalClass.getMethods();

        for (Method method : methods) {
          if (method.isAnnotationPresent(PostProxy.class)) {
            Object bean = context.getBean(name);
            Method currentMethod = bean.getClass().getMethod(method.getName(), method.getParameterTypes());
            currentMethod.invoke(bean);
          }
        }

      } catch (Exception e) {
        e.printStackTrace();
      }

    }
  }
}
