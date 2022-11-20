package org.springframework.boot.actuate.autoconfigure.endpoint.web;

import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.actuate.endpoint.web.annotation.ServletEndpointDiscoverer;
import org.springframework.context.ApplicationContext;

public final class ContextBootstrapInitializer {
  public static void registerWebEndpointAutoConfiguration_WebEndpointServletConfiguration(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointAutoConfiguration$WebEndpointServletConfiguration", WebEndpointAutoConfiguration.WebEndpointServletConfiguration.class)
        .instanceSupplier(WebEndpointAutoConfiguration.WebEndpointServletConfiguration::new).register(beanFactory);
  }

  public static void registerWebEndpointServletConfiguration_servletEndpointDiscoverer(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("servletEndpointDiscoverer", ServletEndpointDiscoverer.class).withFactoryMethod(WebEndpointAutoConfiguration.WebEndpointServletConfiguration.class, "servletEndpointDiscoverer", ApplicationContext.class, ObjectProvider.class, ObjectProvider.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(WebEndpointAutoConfiguration.WebEndpointServletConfiguration.class).servletEndpointDiscoverer(attributes.get(0), attributes.get(1), attributes.get(2)))).register(beanFactory);
  }
}
