package org.faac.ebb.training;

import io.vertx.core.AbstractVerticle;

public class MessageVerticle extends AbstractVerticle {
	public static String EVENT_BUS_ADDRESS = "MESSAGE_VERTICLE_ADDRESS";
	
	@Override
	public void start() throws Exception {
		vertx.eventBus().consumer(EVENT_BUS_ADDRESS, messageHandler -> {
			System.out.println("I've got your message " + messageHandler.body().toString());
			messageHandler.reply("I've got your message");
		});
		super.start();
	}

}
