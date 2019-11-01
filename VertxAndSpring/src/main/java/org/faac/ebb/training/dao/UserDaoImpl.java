package org.faac.ebb.training.dao;

import io.vertx.core.Vertx;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.jdbc.JDBCClient;
import io.vertx.ext.sql.SQLClient;
import io.vertx.ext.sql.SQLConnection;
import io.vertx.ext.web.RoutingContext;

public class UserDaoImpl implements UserDao {
	@Override
	public void insert(RoutingContext context, Vertx vertx) {
		JsonObject config = new JsonObject().put("url", "jdbc:postgresql://localhost:5432/training")
				.put("driver_class", "org.postgresql.Driver").put("user", "postgres").put("password", "postgres")
				.put("max_pool_size", 30);

		SQLClient client = JDBCClient.createNonShared(vertx, config);
		client.getConnection(res -> {
			if (res.succeeded()) {

				SQLConnection connection = res.result();

				connection.query("SELECT * FROM public.user", userAsyncResultHandler -> {
					client.close();
					if (userAsyncResultHandler.succeeded()) {
						JsonArray arr = new JsonArray();
						userAsyncResultHandler.result().getRows().forEach(arr::add);
						context.response().putHeader("content-type", "application/json").end(arr.encode());
					} else {
						System.out.println("DB ERROR");
					}
				});
			} else {
				System.out.println("No connection.");
			}
		});
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}

}
