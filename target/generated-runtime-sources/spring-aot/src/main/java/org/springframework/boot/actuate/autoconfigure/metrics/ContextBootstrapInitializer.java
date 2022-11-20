package org.springframework.boot.actuate.autoconfigure.metrics;

import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;

public final class ContextBootstrapInitializer {
  public static void registerMetricsAutoConfiguration_meterRegistryPostProcessor(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("meterRegistryPostProcessor", MeterRegistryPostProcessor.class).withFactoryMethod(MetricsAutoConfiguration.class, "meterRegistryPostProcessor", ObjectProvider.class, ObjectProvider.class, ObjectProvider.class, ObjectProvider.class, ApplicationContext.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> MetricsAutoConfiguration.meterRegistryPostProcessor(attributes.get(0), attributes.get(1), attributes.get(2), attributes.get(3), attributes.get(4)))).register(beanFactory);
  }
}
