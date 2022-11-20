package org.springframework.boot.actuate.autoconfigure.metrics.web.client;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties;
import org.springframework.boot.actuate.metrics.web.client.DefaultRestTemplateExchangeTagsProvider;
import org.springframework.boot.actuate.metrics.web.client.MetricsRestTemplateCustomizer;
import org.springframework.boot.actuate.metrics.web.client.RestTemplateExchangeTagsProvider;

public final class ContextBootstrapInitializer {
  public static void registerRestTemplateMetricsConfiguration(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.boot.actuate.autoconfigure.metrics.web.client.RestTemplateMetricsConfiguration", RestTemplateMetricsConfiguration.class)
        .instanceSupplier(RestTemplateMetricsConfiguration::new).register(beanFactory);
  }

  public static void registerRestTemplateMetricsConfiguration_restTemplateExchangeTagsProvider(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("restTemplateExchangeTagsProvider", DefaultRestTemplateExchangeTagsProvider.class).withFactoryMethod(RestTemplateMetricsConfiguration.class, "restTemplateExchangeTagsProvider")
        .instanceSupplier(() -> beanFactory.getBean(RestTemplateMetricsConfiguration.class).restTemplateExchangeTagsProvider()).register(beanFactory);
  }

  public static void registerRestTemplateMetricsConfiguration_metricsRestTemplateCustomizer(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("metricsRestTemplateCustomizer", MetricsRestTemplateCustomizer.class).withFactoryMethod(RestTemplateMetricsConfiguration.class, "metricsRestTemplateCustomizer", MeterRegistry.class, RestTemplateExchangeTagsProvider.class, MetricsProperties.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(RestTemplateMetricsConfiguration.class).metricsRestTemplateCustomizer(attributes.get(0), attributes.get(1), attributes.get(2)))).register(beanFactory);
  }
}
