# TemplateGradle

##import java.sql.Types;
```
import org.hibernate.dialect.Oracle12cDialect;
import org.hibernate.type.StandardBasicTypes;

public class CustomDialectOracle extends Oracle12cDialect {

	public CustomDialectOracle() {
		super();
		registerHibernateType(Types.NCHAR, StandardBasicTypes.CHARACTER.getName());
		registerHibernateType(Types.NCHAR, 1, StandardBasicTypes.CHARACTER.getName());
		registerHibernateType(Types.NCHAR, 255, StandardBasicTypes.STRING.getName());
		registerHibernateType(Types.NVARCHAR, StandardBasicTypes.STRING.getName());
		registerHibernateType(Types.LONGNVARCHAR, StandardBasicTypes.TEXT.getName());
		registerHibernateType(Types.NCLOB, StandardBasicTypes.CLOB.getName());
	}

}
```

```
import java.sql.Types;
import org.hibernate.dialect.Oracle12cDialect;
import org.hibernate.type.StandardBasicTypes;

public class CustomDialectOracle extends Oracle12cDialect {

	public CustomDialectOracle() {
		super();
		registerHibernateType(Types.NCHAR, StandardBasicTypes.CHARACTER.getName());
		registerHibernateType(Types.NCHAR, 1, StandardBasicTypes.CHARACTER.getName());
		registerHibernateType(Types.NCHAR, 255, StandardBasicTypes.STRING.getName());
		registerHibernateType(Types.NVARCHAR, StandardBasicTypes.STRING.getName());
		registerHibernateType(Types.LONGNVARCHAR, StandardBasicTypes.TEXT.getName());
		registerHibernateType(Types.NCLOB, StandardBasicTypes.CLOB.getName());
	}

}
```
```
Replace
HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
vendorAdapter.setDatabase(Database.ORACLE);
vendorAdapter.setShowSql(true);

By
HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
vendorAdapter.setDatabase(Database.ORACLE);
vendorAdapter.setDatabasePlatform("com.roytuts.dialect.CustomDialectOracle");
vendorAdapter.setShowSql(true);

```


```
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.roytuts.jparepo")
public class OracleDbConfig {
	@Bean
	public DataSource dataSource() throws SQLException {
		OracleDataSource dataSource = new OracleDataSource();
		dataSource.setUser("");
		dataSource.setPassword("");
		dataSource.setURL(
										"jdbc:Oracle:thin:@//:/");
		dataSource.setImplicitCachingEnabled(true);
		dataSource.setFastConnectionFailoverEnabled(true);
		return dataSource;
	}
	@Bean
	public EntityManagerFactory entityManagerFactory() throws SQLException {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setDatabase(Database.ORACLE);
		vendorAdapter.setShowSql(true);
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan("com.roytuts.model");
		factory.setDataSource(dataSource());
		factory.afterPropertiesSet();
		return factory.getObject();
	}
	@Bean
	public PlatformTransactionManager transactionManager() throws SQLException {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory());
		return txManager;
	}
}
```
