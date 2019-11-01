package org.faac.ebb.training.config;

import org.faac.ebb.training.UserVerticle;
import org.faac.ebb.training.dao.UserDao;
import org.faac.ebb.training.dao.UserDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.jdbc.JDBCClient;
import io.vertx.ext.sql.SQLClient;

@Configuration
@ComponentScan("org.faac.ebb.training.config")
public class SpringConfiguration {
	
	@Bean
	public Vertx vertx() {
		return Vertx.vertx();
	}
	@Bean
	public UserVerticle userVerticle() {
		return new UserVerticle();
	}
	
	@Bean
	public UserDao userDao() {
		return new UserDaoImpl();
	}
}
