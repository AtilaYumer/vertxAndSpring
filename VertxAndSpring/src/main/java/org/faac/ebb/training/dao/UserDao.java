package org.faac.ebb.training.dao;

import java.util.List;

import org.faac.ebb.training.model.User;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;

public interface UserDao {

	public void insert();

	public void update();

	public void delete();
	
	public void getUsers(RoutingContext context, Handler<AsyncResult<List<User>>> resultHandler);
}
