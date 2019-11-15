package org.faac.ebb.training.config;

import org.faac.ebb.training.UserService;
import org.faac.ebb.training.UserServiceImpl;
import org.faac.ebb.training.UserVerticle;
import org.faac.ebb.training.dao.UserDao;
import org.faac.ebb.training.dao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Qualifier;
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
	public SQLClient sqlClient(Vertx vertx, @Qualifier("dbConfig") JsonObject config) {
		return JDBCClient.createNonShared(vertx, config);
	}
	
	@Bean("dbConfig")
	public JsonObject jsonConfig() {
		return  new JsonObject()
				.put("url", "jdbc:postgresql://localhost:5432/training")
				.put("driver_class", "org.postgresql.Driver")
				.put("user", "postgres")
				.put("password", "postgres")
				.put("max_pool_size", 30);
	}
	@Bean
	public UserVerticle userVerticle() {
		return new UserVerticle();
	}
	
	@Bean
	public UserDao userDao() {
		return new UserDaoImpl();
	}
	
	@Bean
	public UserService userService() {
		return new UserServiceImpl();
	}
}
