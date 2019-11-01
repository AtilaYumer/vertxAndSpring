package org.faac.ebb.training;

import io.vertx.core.Vertx;
import io.vertx.ext.web.RoutingContext;

public interface UserService {
	void createUser();
	
	void findUsers(RoutingContext context, Vertx vertx);
}
