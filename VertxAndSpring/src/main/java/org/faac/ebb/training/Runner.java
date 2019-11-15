package org.faac.ebb.training;

import org.faac.ebb.training.config.SpringConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import io.vertx.core.Vertx;

public class Runner {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);

		UserVerticle userVerticle = (UserVerticle) context.getBean(UserVerticle.class);
		MessageVerticle messageVerticle = (MessageVerticle) context.getBean(MessageVerticle.class);
		Vertx vertx = Vertx.vertx();
		vertx.deployVerticle(userVerticle);
		vertx.deployVerticle(messageVerticle);
	}
}
