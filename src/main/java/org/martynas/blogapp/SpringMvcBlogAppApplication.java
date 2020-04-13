package org.martynas.blogapp;

import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLException;

@SpringBootApplication
public class SpringMvcBlogAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMvcBlogAppApplication.class, args);
    }

    // Start internal H2 server so we can query the DB from IDE
    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server inMemoryH2DatabaseServer() throws SQLException {
        return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092");
    }
}
