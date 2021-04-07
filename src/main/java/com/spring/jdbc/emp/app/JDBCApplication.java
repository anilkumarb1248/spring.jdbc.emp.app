package com.spring.jdbc.emp.app;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.jdbc.emp.app.client.JdbcClient;

@SpringBootApplication
public class JDBCApplication implements CommandLineRunner {

	@Autowired
	JdbcClient jdbcClient;

	public static void main(String[] args) {
		SpringApplication.run(JDBCApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		jdbcClient.performDBOperations();
	}

	@Bean
	public DataSource mysqlDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/empdb");
		dataSource.setUsername("anil");
		dataSource.setPassword("anil");
		return dataSource;
	}

}
