package org.faac.ebb.training;

import org.faac.ebb.training.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

@SuppressWarnings("deprecation")
public class UserVerticle extends AbstractVerticle {
	private static String USER_PATH = "/user";

	@Autowired
	private UserDao userDao;

	
	@Override
	public void start() throws Exception {
		Router router = Router.router(vertx);
		router.get(UserVerticle.USER_PATH + "/create").handler(this::createUser);

		vertx.createHttpServer().requestHandler(router::accept).listen(8080);
	}

	@Override
	public void stop() throws Exception {
		vertx.close();
	}

	private void createUser(RoutingContext context) {
		userDao.insert(context, vertx);
	}
}