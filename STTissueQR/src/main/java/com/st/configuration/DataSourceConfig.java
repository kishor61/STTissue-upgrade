/**
 * 
 */
package com.st.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
/**
 * kishor vaishnav
 */
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Value("${jdbc.driverClassName}")
    private String driverClassName;

    @Value("${jdbc.database.url}")
    private String databaseUrl;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Value("${jdbc.driverClassName2}")
    private String driverClassName2;

    @Value("${jdbc.database2.url}")
    private String databaseUrl2;

    @Value("${jdbc.username2}")
    private String username2;

    @Value("${jdbc.password2}")
    private String password2;

    @Value("${jdbc.driverClassName3}")
    private String driverClassName3;

    @Value("${jdbc.database3.url}")
    private String databaseUrl3;

    @Value("${jdbc.username3}")
    private String username3;

    @Value("${jdbc.password3}")
    private String password3;

    @Value("${jdbc.driverClassName4}")
    private String driverClassName4;

    @Value("${jdbc.database4.url}")
    private String databaseUrl4;

    @Value("${jdbc.username4}")
    private String username4;

    @Value("${jdbc.password4}")
    private String password4;

    @Bean(name = "dataSourceQRT")
    @Primary
     DataSource dataSourceQRT() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(databaseUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "dataSourceProduction")
     DataSource dataSourceProduction() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName2);
        dataSource.setUrl(databaseUrl2);
        dataSource.setUsername(username2);
        dataSource.setPassword(password2);
        return dataSource;
    }

    @Bean(name = "dataSourceTracker")
     DataSource dataSourceTracker() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName3);
        dataSource.setUrl(databaseUrl3);
        dataSource.setUsername(username3);
        dataSource.setPassword(password3);
        return dataSource;
    }

    @Bean(name = "dataSourceOBCC")
     DataSource dataSourceOBCC() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName4);
        dataSource.setUrl(databaseUrl4);
        dataSource.setUsername(username4);
        dataSource.setPassword(password4);
        return dataSource;
    }
    
    @Bean(name = "dataSourceQRTTemplate")
    @Primary
     JdbcTemplate primaryJdbcTemplate(@Qualifier("dataSourceQRT") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "dataSourceProductionTemplate")
     JdbcTemplate secondaryJdbcTemplate(@Qualifier("dataSourceProduction") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "dataSourceTrackerTemplate")
     JdbcTemplate tertiaryJdbcTemplate(@Qualifier("dataSourceTracker") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
    
    @Bean(name = "dataSourceOBCCTemplate")
     JdbcTemplate dataSourceOBCCTemplate(@Qualifier("dataSourceOBCC") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
