/**
 * 
 */
package com.st.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import jakarta.persistence.EntityManagerFactory;




/**
 * 
 */
@Configuration
@EnableJpaRepositories(
    basePackages = "com.st.repository.qrt", // Package containing the JPA repositories for QRT
    entityManagerFactoryRef = "qrtEntityManagerFactory", // Reference to the EntityManagerFactory bean
    transactionManagerRef = "qrtTransactionManager" // Reference to the TransactionManager bean
)
public class QRTJpaConfig {

    @Primary // This will be the primary EntityManagerFactory
    @Bean(name = "qrtEntityManagerFactory")
     LocalContainerEntityManagerFactoryBean qrtEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("dataSourceQRT") DataSource dataSourceQRT) {
        return builder
                .dataSource(dataSourceQRT)
                .packages("com.st.entity.qrt") // Package containing the entity classes for QRT
                .persistenceUnit("qrtPU") // Persistence unit name
                .build();
    }

    @Primary
    @Bean(name = "qrtTransactionManager")
     PlatformTransactionManager qrtTransactionManager(
            @Qualifier("qrtEntityManagerFactory") EntityManagerFactory qrtEntityManagerFactory) {
        return new JpaTransactionManager(qrtEntityManagerFactory);
    }
}
