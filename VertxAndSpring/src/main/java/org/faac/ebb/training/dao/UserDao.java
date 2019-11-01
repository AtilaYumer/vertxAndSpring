package org.faac.ebb.training.dao;

import io.vertx.core.Vertx;
import io.vertx.ext.web.RoutingContext;

public interface UserDao {

	public void insert();

	public void update();

	public void delete();
	
	public void getUsers(RoutingContext context, Vertx vertx);
}
