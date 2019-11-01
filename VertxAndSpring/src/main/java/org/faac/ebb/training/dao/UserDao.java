package org.faac.ebb.training.dao;

import io.vertx.core.Vertx;
import io.vertx.ext.web.RoutingContext;

public interface UserDao {

	public void insert(RoutingContext context, Vertx vertx);

	public void update();

	public void delete();
}
