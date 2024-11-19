package com.example.useraggregation.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Configuration
@ConfigurationProperties(prefix = "data-sources")
public class DataSourceProperties {

    private List<DataSourceConfig> dataSources;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DataSourceConfig {
        private String name;
        private String url;
        private String table;
        private String user;
        private String password;
        private Map<String, String> mapping;
    }

}