package com.ezen.webstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.ezen.webstore")
public class RootApplicationContextConfig {
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(org.mariadb.jdbc.Driver.class.getName());
        ds.setUrl("jdbc:mariadb://localhost:3306/webstore");
        ds.setUsername("root");
        ds.setPassword("jjicdu4790");
        return ds;
    }


    @Bean
    public NamedParameterJdbcTemplate getJdbcTemplate() {
        return new NamedParameterJdbcTemplate(dataSource());
    }
}
