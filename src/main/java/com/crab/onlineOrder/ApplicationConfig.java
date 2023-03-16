package com.crab.onlineOrder;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueResponse;

import javax.sql.DataSource;
import java.util.Map;
import java.util.Properties;

@Configuration
@EnableWebMvc
public class ApplicationConfig {


    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        String PACKAGE_NAME = "com.crab.onlineOrder.entity";
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(PACKAGE_NAME);
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }


    @Bean
    public DataSource dataSource() {
        // Create a Secrets Manager client
        SecretsManagerClient secretsClient = SecretsManagerClient.create();

        // Get the secret value
        GetSecretValueRequest getSecretValueRequest = GetSecretValueRequest.builder()
                .secretId("crab_eats_passcode")
                .build();
        GetSecretValueResponse getSecretValueResponse = secretsClient.getSecretValue(getSecretValueRequest);

        // Parse the secret JSON string
        String secretString = getSecretValueResponse.secretString();
        Gson gson = new Gson();
        Map<String, String> secretMap = gson.fromJson(secretString, Map.class);

        // Retrieve values from the secret
        String RDS_ENDPOINT = secretMap.get("rds_endpoint");
        String USERNAME = secretMap.get("username");
        String PASSWORD = secretMap.get("password");

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://" + RDS_ENDPOINT + ":3306/onlineOrder?createDatabaseIfNotExist=true&serverTimezone=UTC");
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);

        return dataSource;
    }


    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


    private final Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
        hibernateProperties.setProperty("hibernate.show_sql", "true");
        return hibernateProperties;
    }
}


