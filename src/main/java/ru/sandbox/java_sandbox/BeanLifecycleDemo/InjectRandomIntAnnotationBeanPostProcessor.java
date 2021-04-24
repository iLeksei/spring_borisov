package ru.sandbox.java_sandbox.BeanLifecycleDemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Random;

@Slf4j
//@Component
public class InjectRandomIntAnnotationBeanPostProcessor implements BeanPostProcessor {

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
    LOG.info("phase before initialization beanName {}", beanName);

    Field[] fields = bean.getClass().getDeclaredFields();

    for (Field field : fields) {
      if (field.isAnnotationPresent(InjectRandomInt.class)) {
        field.setAccessible(true); // cause field is private need to get access
        InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
        int min = annotation.min();
        int max = annotation.max();
        int count = min + new Random().nextInt(max - min);
        ReflectionUtils.setField(field, bean, count);
      }
    }


    return bean;
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    LOG.info("phase after initialization beanName {}", beanName);
    return bean;
  }
}
