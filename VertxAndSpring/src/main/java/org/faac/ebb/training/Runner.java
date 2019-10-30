package org.faac.ebb.training;

import org.springframework.context.annotation.ComponentScan;

import io.vertx.core.Vertx;

@ComponentScan(basePackages = {"org.faac.ebb.training.config"})
public class Runner {
	public static void main(String[] args) {
        
		Vertx vertx = Vertx.vertx();
		vertx.deployVerticle(new UserVerticle());
	}
}
