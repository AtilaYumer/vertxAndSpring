package org.faac.ebb.training.config;

import org.faac.ebb.training.dao.UserDao;
import org.faac.ebb.training.dao.UserDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class SpringConfiguration {
	
	@Bean
	public UserDao userDao() {
		return new UserDaoImpl();
	}
}
