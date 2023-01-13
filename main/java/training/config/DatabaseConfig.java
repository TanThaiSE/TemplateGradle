package training.config;

import javax.sql.DataSource;

import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.NoCacheSqlFileRepository;
import org.seasar.doma.jdbc.SqlFileRepository;
import org.seasar.doma.jdbc.SqlLogType;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.seasar.doma.jdbc.dialect.OracleDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

/**
 * Created by tsukasatamaru on 14/11/25.
 */
@Configuration
@EnableTransactionManagement
public class DatabaseConfig {

  @Autowired
  private DataSourceProperties dataSourceProperties;


  @Bean
  DataSource dataSource() {
    HikariDataSource dataSource = new HikariDataSource();
    dataSource.setDriverClassName(this.dataSourceProperties.getDriverClassName());
    dataSource.setJdbcUrl(this.dataSourceProperties.getUrl());
    dataSource.setUsername(this.dataSourceProperties.getUsername());
    dataSource.setPassword(this.dataSourceProperties.getPassword());

    dataSource.setRegisterMbeans(true);
    return new TransactionAwareDataSourceProxy(dataSource);
  }

  @Bean
  public PlatformTransactionManager transactionManager() {
    return new DataSourceTransactionManager(this.dataSource());
  }

  @Bean
  public Dialect dialect() {
    return new OracleDialect();
  }

  @Bean
  public SqlFileRepository sqlFileRepository() {
    return new NoCacheSqlFileRepository();
  }

  @Bean
  public Config domaConfig() {
    return new Config() {

      @Override
      public Dialect getDialect() {
        return dialect();
      }

      @Override
      public DataSource getDataSource() {
        return dataSource();
      }

      @Override
      public SqlFileRepository getSqlFileRepository() {
        return sqlFileRepository();
      }
      @Override
      public SqlLogType getExceptionSqlLogType() {
        return SqlLogType.RAW;
      }
    };
  }

}
