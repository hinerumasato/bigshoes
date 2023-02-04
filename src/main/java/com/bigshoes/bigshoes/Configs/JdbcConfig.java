package com.bigshoes.bigshoes.Configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.bigshoes.bigshoes.Repositories.UserRepository;
import com.bigshoes.bigshoes.Repositories.impl.UserRepositoryImpl;

@Configuration
public class JdbcConfig {
    @Bean("ds")
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/bigshoes");
		ds.setUsername("root");
		ds.setPassword("135792468jK");
		return ds;
	}

	@Bean("jdbcTemplate")
	public JdbcTemplate getTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}

    @Bean("userRepository")
    public UserRepository getUserRepository() {
        UserRepository userRepository = new UserRepositoryImpl();
        return userRepository;
    }
}
