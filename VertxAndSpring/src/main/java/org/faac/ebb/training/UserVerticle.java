package org.faac.ebb.training;

import org.faac.ebb.training.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

@SuppressWarnings("deprecation")
public class UserVerticle extends AbstractVerticle {
	private static String USER_PATH = "/user";

	@Autowired
	private UserService userService;

	
	@Override
	public void start() throws Exception {
		Router router = Router.router(vertx);
		router.get(UserVerticle.USER_PATH + "/get").handler(this::getUsers);
		router.get(UserVerticle.USER_PATH + "/sendMessage").handler(this::sendMessage);

		vertx.createHttpServer().requestHandler(router::accept).listen(8080);
	}

	@Override
	public void stop() throws Exception {
		vertx.close();
	}

	private void getUsers(RoutingContext context) {
	    userService.findUsers(context, findUsersAsynResultHandler -> {
	    	if (findUsersAsynResultHandler.succeeded()) {
	    		JsonArray response = new JsonArray();
	    		for(User user : findUsersAsynResultHandler.result()) {
	    			JsonObject object = new JsonObject(user.toString());
	    			response.add(object);
	    		}
				context.response()
				.putHeader("content-type", "application/json")
				.end(response.toString());
			}
	    });
	}
	
	private void sendMessage(RoutingContext context) {
		vertx.eventBus().send(MessageVerticle.EVENT_BUS_ADDRESS, "Hello, I am userVerticle.", replyHandler -> {
			if (replyHandler.succeeded()) {
				Message<Object> result = replyHandler.result();
				if ("I've got your messageasdasd".equals(result.body().toString())) {
					context.response()
					.putHeader("content-type", "application/json")
					.end("Message is sent.");
				} else {
					context.response()
					.putHeader("content-type", "application/json")
					.end("Message is not sent.");	
				}
			} else {
				context.response()
				.putHeader("content-type", "application/json")
				.end("Message sending failed.");
			}
		});
	}
}
