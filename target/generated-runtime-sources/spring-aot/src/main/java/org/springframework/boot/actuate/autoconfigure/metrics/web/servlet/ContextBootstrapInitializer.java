package org.springframework.boot.actuate.autoconfigure.metrics.web.servlet;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.actuate.metrics.web.servlet.WebMvcTagsProvider;

public final class ContextBootstrapInitializer {
  public static void registerWebMvcMetricsAutoConfiguration_metricsWebMvcConfigurer(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("metricsWebMvcConfigurer", WebMvcMetricsAutoConfiguration.MetricsWebMvcConfigurer.class).withFactoryMethod(WebMvcMetricsAutoConfiguration.class, "metricsWebMvcConfigurer", MeterRegistry.class, WebMvcTagsProvider.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(WebMvcMetricsAutoConfiguration.class).metricsWebMvcConfigurer(attributes.get(0), attributes.get(1)))).register(beanFactory);
  }
}
