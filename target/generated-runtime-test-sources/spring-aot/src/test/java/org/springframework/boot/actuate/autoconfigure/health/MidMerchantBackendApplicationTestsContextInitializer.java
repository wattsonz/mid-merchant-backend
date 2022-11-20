package org.springframework.boot.actuate.autoconfigure.health;

import java.util.Map;
import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.actuate.endpoint.web.WebEndpointsSupplier;
import org.springframework.boot.actuate.endpoint.web.servlet.AdditionalHealthEndpointPathsWebMvcHandlerMapping;
import org.springframework.boot.actuate.health.HealthContributorRegistry;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.boot.actuate.health.HealthEndpointGroups;
import org.springframework.boot.actuate.health.HealthEndpointWebExtension;
import org.springframework.boot.actuate.health.HttpCodeStatusMapper;
import org.springframework.boot.actuate.health.StatusAggregator;
import org.springframework.context.ApplicationContext;

public final class MidMerchantBackendApplicationTestsContextInitializer {
  public static void registerHealthEndpointConfiguration(DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.boot.actuate.autoconfigure.health.HealthEndpointConfiguration", HealthEndpointConfiguration.class)
        .instanceSupplier(HealthEndpointConfiguration::new).register(beanFactory);
  }

  public static void registerHealthEndpointConfiguration_healthStatusAggregator(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("healthStatusAggregator", StatusAggregator.class).withFactoryMethod(HealthEndpointConfiguration.class, "healthStatusAggregator", HealthEndpointProperties.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(HealthEndpointConfiguration.class).healthStatusAggregator(attributes.get(0)))).register(beanFactory);
  }

  public static void registerHealthEndpointConfiguration_healthHttpCodeStatusMapper(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("healthHttpCodeStatusMapper", HttpCodeStatusMapper.class).withFactoryMethod(HealthEndpointConfiguration.class, "healthHttpCodeStatusMapper", HealthEndpointProperties.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(HealthEndpointConfiguration.class).healthHttpCodeStatusMapper(attributes.get(0)))).register(beanFactory);
  }

  public static void registerHealthEndpointConfiguration_healthEndpointGroups(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("healthEndpointGroups", HealthEndpointGroups.class).withFactoryMethod(HealthEndpointConfiguration.class, "healthEndpointGroups", ApplicationContext.class, HealthEndpointProperties.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(HealthEndpointConfiguration.class).healthEndpointGroups(attributes.get(0), attributes.get(1)))).register(beanFactory);
  }

  public static void registerHealthEndpointConfiguration_healthContributorRegistry(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("healthContributorRegistry", HealthContributorRegistry.class).withFactoryMethod(HealthEndpointConfiguration.class, "healthContributorRegistry", ApplicationContext.class, HealthEndpointGroups.class, Map.class, Map.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(HealthEndpointConfiguration.class).healthContributorRegistry(attributes.get(0), attributes.get(1), attributes.get(2), attributes.get(3)))).register(beanFactory);
  }

  public static void registerHealthEndpointConfiguration_healthEndpoint(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("healthEndpoint", HealthEndpoint.class).withFactoryMethod(HealthEndpointConfiguration.class, "healthEndpoint", HealthContributorRegistry.class, HealthEndpointGroups.class, HealthEndpointProperties.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(HealthEndpointConfiguration.class).healthEndpoint(attributes.get(0), attributes.get(1), attributes.get(2)))).register(beanFactory);
  }

  public static void registerHealthEndpointConfiguration_healthEndpointGroupsBeanPostProcessor(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("healthEndpointGroupsBeanPostProcessor", HealthEndpointConfiguration.HealthEndpointGroupsBeanPostProcessor.class).withFactoryMethod(HealthEndpointConfiguration.class, "healthEndpointGroupsBeanPostProcessor", ObjectProvider.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> HealthEndpointConfiguration.healthEndpointGroupsBeanPostProcessor(attributes.get(0)))).register(beanFactory);
  }

  public static void registerHealthEndpointWebExtensionConfiguration_MvcAdditionalHealthEndpointPathsConfiguration(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.boot.actuate.autoconfigure.health.HealthEndpointWebExtensionConfiguration$MvcAdditionalHealthEndpointPathsConfiguration", HealthEndpointWebExtensionConfiguration.MvcAdditionalHealthEndpointPathsConfiguration.class)
        .instanceSupplier(HealthEndpointWebExtensionConfiguration.MvcAdditionalHealthEndpointPathsConfiguration::new).register(beanFactory);
  }

  public static void registerMvcAdditionalHealthEndpointPathsConfiguration_healthEndpointWebMvcHandlerMapping(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("healthEndpointWebMvcHandlerMapping", AdditionalHealthEndpointPathsWebMvcHandlerMapping.class).withFactoryMethod(HealthEndpointWebExtensionConfiguration.MvcAdditionalHealthEndpointPathsConfiguration.class, "healthEndpointWebMvcHandlerMapping", WebEndpointsSupplier.class, HealthEndpointGroups.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(HealthEndpointWebExtensionConfiguration.MvcAdditionalHealthEndpointPathsConfiguration.class).healthEndpointWebMvcHandlerMapping(attributes.get(0), attributes.get(1)))).register(beanFactory);
  }

  public static void registerHealthEndpointWebExtensionConfiguration(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.boot.actuate.autoconfigure.health.HealthEndpointWebExtensionConfiguration", HealthEndpointWebExtensionConfiguration.class)
        .instanceSupplier(HealthEndpointWebExtensionConfiguration::new).register(beanFactory);
  }

  public static void registerHealthEndpointWebExtensionConfiguration_healthEndpointWebExtension(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("healthEndpointWebExtension", HealthEndpointWebExtension.class).withFactoryMethod(HealthEndpointWebExtensionConfiguration.class, "healthEndpointWebExtension", HealthContributorRegistry.class, HealthEndpointGroups.class, HealthEndpointProperties.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(HealthEndpointWebExtensionConfiguration.class).healthEndpointWebExtension(attributes.get(0), attributes.get(1), attributes.get(2)))).register(beanFactory);
  }
}
