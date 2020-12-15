package com.lti.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@Configuration
@EnableTransactionManagement
public class AppConfig {

	@Bean
	public DataSource dataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		basicDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:banking");
		basicDataSource.setUsername("system");
		basicDataSource.setPassword("27Dec1998");
		basicDataSource.setInitialSize(10);
		basicDataSource.setMaxActive(100);
		return basicDataSource;
	}

	@Bean
	public Properties hibernateProperties() {
		Properties hProperties = new Properties();
		hProperties.put("hibernate.show_sql", true);
		hProperties.put("hibernate.format_sql", true);
		hProperties.put("hibernate.use_sql_comments", true);
		hProperties.put("hibernate.hbm2ddl.auto", "update");
		hProperties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		return hProperties;
	}

	@Bean
	public LocalSessionFactoryBean getLocalSessionFactory() {
		LocalSessionFactoryBean lBean = new LocalSessionFactoryBean();
		lBean.setPackagesToScan("com.lti");
		lBean.setDataSource(dataSource());
		lBean.setHibernateProperties(hibernateProperties());
		return lBean;
	}

	@Bean
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(getLocalSessionFactory().getObject());
		return transactionManager;
	}

}
