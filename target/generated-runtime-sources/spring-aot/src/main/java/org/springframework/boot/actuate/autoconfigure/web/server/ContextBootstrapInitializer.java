package org.springframework.boot.actuate.autoconfigure.web.server;

import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.core.env.Environment;

public final class ContextBootstrapInitializer {
  public static void registerSameManagementContextConfiguration_EnableSameManagementContextConfiguration(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.boot.actuate.autoconfigure.web.server.ManagementContextAutoConfiguration$SameManagementContextConfiguration$EnableSameManagementContextConfiguration", ManagementContextAutoConfiguration.SameManagementContextConfiguration.EnableSameManagementContextConfiguration.class)
        .instanceSupplier(ManagementContextAutoConfiguration.SameManagementContextConfiguration.EnableSameManagementContextConfiguration::new).register(beanFactory);
  }

  public static void registerManagementContextAutoConfiguration_SameManagementContextConfiguration(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.boot.actuate.autoconfigure.web.server.ManagementContextAutoConfiguration$SameManagementContextConfiguration", ManagementContextAutoConfiguration.SameManagementContextConfiguration.class).withConstructor(Environment.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> new ManagementContextAutoConfiguration.SameManagementContextConfiguration(attributes.get(0)))).register(beanFactory);
  }
}
