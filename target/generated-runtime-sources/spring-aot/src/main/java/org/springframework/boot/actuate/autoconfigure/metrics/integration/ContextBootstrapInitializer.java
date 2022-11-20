package org.springframework.boot.actuate.autoconfigure.metrics.integration;

import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

public final class ContextBootstrapInitializer {
  public static void registerIntegrationMetricsAutoConfiguration(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.boot.actuate.autoconfigure.metrics.integration.IntegrationMetricsAutoConfiguration", IntegrationMetricsAutoConfiguration.class)
        .instanceSupplier(IntegrationMetricsAutoConfiguration::new).register(beanFactory);
  }
}
