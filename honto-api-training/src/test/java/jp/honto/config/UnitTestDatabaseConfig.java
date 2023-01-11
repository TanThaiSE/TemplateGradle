package jp.honto.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by hiroshi.onodera on 2017/02/01.
 */
@Configuration()
@EnableTransactionManagement
@Profile(value = "ora-dbunit")
public class UnitTestDatabaseConfig {
  @Autowired
  DataSourceProperties prop;

  @Bean
  DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setUrl(this.prop.getUrl());
    dataSource.setUsername(this.prop.getUsername());
    dataSource.setPassword(this.prop.getPassword());
    return new TransactionAwareDataSourceProxy(dataSource);
  }
}
