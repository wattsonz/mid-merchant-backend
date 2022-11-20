package org.springframework.boot.actuate.autoconfigure.metrics.data;

import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

public final class MidMerchantBackendApplicationTestsContextInitializer {
  public static void registerRepositoryMetricsAutoConfiguration_metricsRepositoryMethodInvocationListenerBeanPostProcessor(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("metricsRepositoryMethodInvocationListenerBeanPostProcessor", MetricsRepositoryMethodInvocationListenerBeanPostProcessor.class).withFactoryMethod(RepositoryMetricsAutoConfiguration.class, "metricsRepositoryMethodInvocationListenerBeanPostProcessor", ObjectProvider.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> RepositoryMetricsAutoConfiguration.metricsRepositoryMethodInvocationListenerBeanPostProcessor(attributes.get(0)))).register(beanFactory);
  }
}
