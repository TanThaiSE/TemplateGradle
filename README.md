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

```
<html><body><h1>Whitelabel Error Page</h1><p>This application has no explicit mapping for /error, so you are seeing this as a fallback.</p><div id='created'>Mon Jan 16 18:42:54 JST 2023</div><div>There was an unexpected error (type=Internal Server Error, status=500).</div><div>could not prepare statement</div></body></html>
```
