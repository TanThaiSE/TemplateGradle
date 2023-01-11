package jp.honto.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.github.springtestdbunit.bean.DatabaseConfigBean;
import com.github.springtestdbunit.bean.DatabaseDataSourceConnectionFactoryBean;

/**
 * Created by chiaki.hasegawa on 2015/01/08.
 */
@Configuration
public class DbunitConfig extends WebMvcConfigurerAdapter {

  @Autowired
  DataSourceProperties prop;

  @Autowired
  DataSource dataSource;

  @Bean
  DatabaseConfigBean dbUnitDatabaseConfig() {
    DatabaseConfigBean dbUnitConfig = new DatabaseConfigBean();
    return dbUnitConfig;
  }

  @Bean
  DatabaseDataSourceConnectionFactoryBean dbUnitDatabaseConnection() {
    DatabaseDataSourceConnectionFactoryBean dbUnitConnection = new DatabaseDataSourceConnectionFactoryBean(this.dataSource);
    dbUnitConnection.setDatabaseConfig(dbUnitDatabaseConfig());
    dbUnitConnection.setSchema(this.prop.getSchema());
    return dbUnitConnection;
  }
}
