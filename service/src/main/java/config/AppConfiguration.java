package config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import controller.AccountController;
import entity.Account;
import service.AccountService;

@Configuration
@EnableJpaRepositories(basePackages = {
        "dao"
})
@EnableWebMvc
@PropertySource(value="classpath:application.properties")
@ComponentScan(basePackageClasses={AccountController.class,AccountService.class})
@EntityScan(basePackageClasses={Account.class})
@EnableTransactionManagement
public class AppConfiguration {

    @Autowired
    private Environment environement;
    
    
    @Bean
    DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environement.getProperty("db.driver"));
        dataSource.setUrl(environement.getProperty("db.url"));
        dataSource.setUsername(environement.getProperty("db.username"));
        dataSource.setPassword(environement.getProperty("db.password"));
        return dataSource;
    }
    
    
    @Bean
    JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
    
    
    @Bean(name={"entityManagerFactory"})
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
       LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
       entityManagerFactory.setDataSource(dataSource());
       entityManagerFactory.setPackagesToScan(new String[] { "entity" });
  
       JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
       entityManagerFactory.setJpaVendorAdapter(vendorAdapter);
       entityManagerFactory.setJpaProperties(additionalProperties());
  
       return entityManagerFactory;
    }
    
    
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory){
       JpaTransactionManager transactionManager = new JpaTransactionManager();
       transactionManager.setEntityManagerFactory(entityManagerFactory);
  
       return transactionManager;
    }
    
    
    Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", environement.getProperty("hibernate.hbm2ddl.auto"));
        properties.setProperty("hibernate.dialect", environement.getProperty("hibernate.dialect"));
        return properties;
     }
    
}
