package com.example.useraggregation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class JdbcTemplateFactoryImpl implements JdbcTemplateFactory {

    private final JdbcTemplate jdbcTemplate1;
    private final JdbcTemplate jdbcTemplate2;

    @Autowired
    public JdbcTemplateFactoryImpl(@Qualifier("dataSource1") JdbcTemplate jdbcTemplate1,
                                   @Qualifier("dataSource2") JdbcTemplate jdbcTemplate2) {
        this.jdbcTemplate1 = jdbcTemplate1;
        this.jdbcTemplate2 = jdbcTemplate2;
    }

    @Override
    public JdbcTemplate getJdbcTemplate(String databaseName) {
        return switch (databaseName) {
            case "database1" -> jdbcTemplate1;
            case "database2" -> jdbcTemplate2;
            default -> throw new IllegalArgumentException("No JdbcTemplate found for database: " + databaseName);
        };
    }
}
