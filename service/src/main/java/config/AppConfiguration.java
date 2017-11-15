package config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
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
@ComponentScan(basePackageClasses={AccountController.class,AccountService.class})
@EntityScan(basePackageClasses={Account.class})
@EnableTransactionManagement
public class AppConfiguration {

    @Value("${db.driver}")
    private String driverClassName;
    
    @Value("${db.url}")
    private String dbUrl;
    
    @Value("${db.username}")
    private String dbUserId;
    
    @Value("${db.password}")
    private String dbPassword;
    
    @Value("${hibernate.dialect}")
    private String dialect;
    
    @Value("${hibernate.hbm2ddl.auto}")
    private String hbm2ddlAuto;
    
    @Value("${hibernate.show_sql}")
    private String showSql;
    
    @Value("${hibernate.format_sql}")
    private String formatSql;
    
    
    @Bean
    DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(dbUserId);
        dataSource.setPassword(dbPassword);
        return dataSource;
    }
    
    
    @Bean
    JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
    
}
