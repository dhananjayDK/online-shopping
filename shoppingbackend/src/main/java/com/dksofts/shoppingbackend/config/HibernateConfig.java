package com.dksofts.shoppingbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author dksoftware
 *
 */

@Configuration
@ComponentScan(basePackages={"com.dksofts.shoppingbackend.dto"})
@EnableTransactionManagement
public class HibernateConfig {
   private final static String drivername="org.h2.Driver";
   private final static String url="jdbc:h2:tcp://localhost/~/onlineshopping";
   private final static String username="sa";
   private final static String password="";
   private final static String dialect="org.hibernate.dialect.H2Dialect";
   
   @Bean
   public DataSource getDataSource(){
	   
	   BasicDataSource dataSource = new BasicDataSource();
	   dataSource.setUsername(username);
	   dataSource.setUrl(url);
	   dataSource.setPassword(password);
	   dataSource.setDriverClassName(drivername);
	   return dataSource;
   }
   
   @Bean
   public SessionFactory getSessionFactory(DataSource dataSource){
	   LocalSessionFactoryBuilder localSessionFactoryBuilder = 
			   new LocalSessionFactoryBuilder(dataSource);
	   localSessionFactoryBuilder.addProperties(getHibernateProperties());
	   localSessionFactoryBuilder.scanPackages("com.dksofts.shoppingbackend.dto");
	   return localSessionFactoryBuilder.buildSessionFactory();
	   
   }
   public Properties getHibernateProperties(){
	   Properties p = new Properties();
	   p.setProperty("hibernate.dialect", dialect);
	   p.setProperty("hibernate.show_sql", "true");
	   p.setProperty("hibernate.format_sql", "true");
	   return p;
   }
   
   @Bean
   public HibernateTransactionManager getHibernateTransactionManager(SessionFactory factory){
	   HibernateTransactionManager transactionManager =
			   new HibernateTransactionManager(factory);
	   return transactionManager;
	   
   }
}
