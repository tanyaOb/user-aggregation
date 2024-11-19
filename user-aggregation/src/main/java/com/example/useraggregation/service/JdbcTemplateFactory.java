package com.example.useraggregation.service;

import org.springframework.jdbc.core.JdbcTemplate;

public interface JdbcTemplateFactory {
    JdbcTemplate getJdbcTemplate(String databaseName);
}