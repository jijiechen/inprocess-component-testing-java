package org.twj.component.testing.data;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;

@Configuration
public class MySqlLocalDataSourceConfig  {

    @Bean
    public DataSource dataSource() {
        return createBasicDataSource("jdbc:mysql://localhost/componenttesting", "com.mysql.jdbc.Driver", "root", "admin");
    }

    protected BasicDataSource createBasicDataSource(String jdbcUrl, String driverClass, String userName, String password) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(jdbcUrl);
        dataSource.setDriverClassName(driverClass);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        return dataSource;
    }

}
