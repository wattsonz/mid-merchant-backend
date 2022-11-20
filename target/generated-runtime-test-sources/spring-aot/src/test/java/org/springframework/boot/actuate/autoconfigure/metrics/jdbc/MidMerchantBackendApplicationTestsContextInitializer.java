package org.springframework.boot.actuate.autoconfigure.metrics.jdbc;

import java.util.Map;
import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

public final class MidMerchantBackendApplicationTestsContextInitializer {
  public static void registerDataSourcePoolMetricsAutoConfiguration_HikariDataSourceMetricsConfiguration(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.boot.actuate.autoconfigure.metrics.jdbc.DataSourcePoolMetricsAutoConfiguration$HikariDataSourceMetricsConfiguration", DataSourcePoolMetricsAutoConfiguration.HikariDataSourceMetricsConfiguration.class)
        .instanceSupplier(DataSourcePoolMetricsAutoConfiguration.HikariDataSourceMetricsConfiguration::new).register(beanFactory);
  }

  public static void registerHikariDataSourceMetricsConfiguration_hikariDataSourceMeterBinder(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("hikariDataSourceMeterBinder", DataSourcePoolMetricsAutoConfiguration.HikariDataSourceMetricsConfiguration.HikariDataSourceMeterBinder.class).withFactoryMethod(DataSourcePoolMetricsAutoConfiguration.HikariDataSourceMetricsConfiguration.class, "hikariDataSourceMeterBinder", ObjectProvider.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(DataSourcePoolMetricsAutoConfiguration.HikariDataSourceMetricsConfiguration.class).hikariDataSourceMeterBinder(attributes.get(0)))).register(beanFactory);
  }

  public static void registerDataSourcePoolMetricsAutoConfiguration_DataSourcePoolMetadataMetricsConfiguration(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.boot.actuate.autoconfigure.metrics.jdbc.DataSourcePoolMetricsAutoConfiguration$DataSourcePoolMetadataMetricsConfiguration", DataSourcePoolMetricsAutoConfiguration.DataSourcePoolMetadataMetricsConfiguration.class)
        .instanceSupplier(DataSourcePoolMetricsAutoConfiguration.DataSourcePoolMetadataMetricsConfiguration::new).register(beanFactory);
  }

  public static void registerDataSourcePoolMetadataMetricsConfiguration_dataSourcePoolMetadataMeterBinder(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("dataSourcePoolMetadataMeterBinder", DataSourcePoolMetricsAutoConfiguration.DataSourcePoolMetadataMetricsConfiguration.DataSourcePoolMetadataMeterBinder.class).withFactoryMethod(DataSourcePoolMetricsAutoConfiguration.DataSourcePoolMetadataMetricsConfiguration.class, "dataSourcePoolMetadataMeterBinder", Map.class, ObjectProvider.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(DataSourcePoolMetricsAutoConfiguration.DataSourcePoolMetadataMetricsConfiguration.class).dataSourcePoolMetadataMeterBinder(attributes.get(0), attributes.get(1)))).register(beanFactory);
  }
}
