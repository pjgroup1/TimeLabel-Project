package com.javateam.TimeLabel.dbutil;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.javateam.TimeLabel.repository.UserRepositoryImpl;
import com.javateam.TimeLabel.repositoryImpl.UserRepository;
import com.javateam.TimeLabel.service.UserSearch;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class JdbcTemplateConfig {
	
	private final DataSource dataSource;
	
	
	/*public JdbcTemplateConfig(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}*/
	
	@Bean
	public UserRepository userRepository() {
		return new UserRepositoryImpl(dataSource);
	}
	
	/*public UserSearch userSearch() {
		return new UserRepository(dataSource);
	}*/
}
