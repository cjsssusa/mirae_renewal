package kr.co.landfuture.api.compareAbi.config;

import java.util.HashMap;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@PropertySource({ "classpath:application.properties" })
@EnableJpaRepositories(basePackages = {
        "kr.co.landfuture.api.compareAbi.repo" }, entityManagerFactoryRef = "abiEntityManager", transactionManagerRef = "abiTransactionManager")
public class AbiConfig {
    @Autowired
    private Environment env;

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean abiEntityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(abiDataSource());
        em.setPackagesToScan(new String[] { "kr.co.landfuture.api.compareAbi.data" });

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter((JpaVendorAdapter) vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", this.env.getProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.dialect", this.env.getProperty("hibernate.dialect"));
        em.setJpaPropertyMap(properties);

        return em;
    }

    @Primary
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource abiDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean
    public PlatformTransactionManager abiTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(abiEntityManager().getObject());
        return (PlatformTransactionManager) transactionManager;
    }

    @Bean
    NamedParameterJdbcOperations jdbcOperationsAbi(@Qualifier("abiDataSource") DataSource sqlServerDs) {
        return (NamedParameterJdbcOperations) new NamedParameterJdbcTemplate(sqlServerDs);
    }
}
