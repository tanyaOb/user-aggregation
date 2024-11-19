package com.example.useraggregation.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class MultiDataSourceConfig {

    private final DataSourceProperties dataSourceProperties;

    @Bean(name = "dataSource1")
    @Primary
    public JdbcTemplate dataSource1() {
        return createJdbcTemplate(dataSourceProperties.getDataSources().get(0));
    }

    @Bean(name = "dataSource2")
    public JdbcTemplate dataSource2() {
        return createJdbcTemplate(dataSourceProperties.getDataSources().get(1));
    }

    private JdbcTemplate createJdbcTemplate(DataSourceProperties.DataSourceConfig dataSourceConfig) {
        DataSource dataSource = buildDataSource(dataSourceConfig);
        return new JdbcTemplate(dataSource);
    }

    private DataSource buildDataSource(DataSourceProperties.DataSourceConfig dataSourceConfig) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(dataSourceConfig.getUrl());
        dataSource.setUsername(dataSourceConfig.getUser());
        dataSource.setPassword(dataSourceConfig.getPassword());
        return dataSource;
    }

}