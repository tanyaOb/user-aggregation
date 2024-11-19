package com.example.useraggregation.service;

import com.example.useraggregation.config.DataSourceProperties;
import com.example.useraggregation.dto.User;
import com.example.useraggregation.repository.UserRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final JdbcTemplateFactory jdbcTemplateFactory;

    private final List<DataSourceProperties.DataSourceConfig> dataSources;

    @Autowired
    public UserService(JdbcTemplateFactory jdbcTemplateFactory, DataSourceProperties dataSourceProperties) {
        this.jdbcTemplateFactory = jdbcTemplateFactory;
        this.dataSources = dataSourceProperties.getDataSources();
    }

    public List<User> getUsers() {
        List<User> allUsers = new ArrayList<>();

        for (DataSourceProperties.DataSourceConfig dataSourceConfig : dataSources) {
            String query = "SELECT * FROM " + dataSourceConfig.getTable();

            JdbcTemplate jdbcTemplate = jdbcTemplateFactory.getJdbcTemplate(dataSourceConfig.getName());

            UserRowMapper userRowMapper = new UserRowMapper(dataSourceConfig.getMapping());

            List<User> users = jdbcTemplate.query(query, userRowMapper);
            allUsers.addAll(users);
        }

        return allUsers;
    }

}
