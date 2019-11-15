package org.faac.ebb.training;

import java.util.List;

import org.faac.ebb.training.model.User;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;

public interface UserService {
	
	void createUser(RoutingContext context, Handler<AsyncResult<List<User>>> resultHandle);

	void findUsers(RoutingContext context, Handler<AsyncResult<List<User>>> resultHandler);
}
