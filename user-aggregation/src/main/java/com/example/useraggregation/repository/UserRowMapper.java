package com.example.useraggregation.repository;

import com.example.useraggregation.dto.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class UserRowMapper implements RowMapper<User> {

    private final Map<String, String> columnMapping;

    public UserRowMapper(Map<String, String> columnMapping) {
        this.columnMapping = columnMapping;
    }

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();

        user.setId(rs.getString(columnMapping.get("id")));
        user.setUsername(rs.getString(columnMapping.get("username")));
        user.setName(rs.getString(columnMapping.get("name")));
        user.setSurname(rs.getString(columnMapping.get("surname")));

        return user;
    }
}