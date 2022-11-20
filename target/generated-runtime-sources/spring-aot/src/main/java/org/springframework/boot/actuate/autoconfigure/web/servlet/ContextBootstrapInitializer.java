package org.springframework.boot.actuate.autoconfigure.web.servlet;

import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

public final class ContextBootstrapInitializer {
  public static void registerServletManagementContextAutoConfiguration_servletWebChildContextFactory(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("servletWebChildContextFactory", ServletManagementContextFactory.class).withFactoryMethod(ServletManagementContextAutoConfiguration.class, "servletWebChildContextFactory")
        .instanceSupplier(() -> beanFactory.getBean(ServletManagementContextAutoConfiguration.class).servletWebChildContextFactory()).register(beanFactory);
  }
}
