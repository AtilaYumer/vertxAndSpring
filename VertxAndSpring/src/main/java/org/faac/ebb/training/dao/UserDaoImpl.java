package org.faac.ebb.training.dao;

import java.util.ArrayList;
import java.util.List;

import org.faac.ebb.training.config.AsyncResultBuilder;
import org.faac.ebb.training.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.ext.sql.SQLClient;
import io.vertx.ext.sql.SQLConnection;
import io.vertx.ext.web.RoutingContext;

public class UserDaoImpl implements UserDao {

	@Autowired
	private SQLClient client;

	@Override
	public void insert() {

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}

	@Override
	public void getUsers(RoutingContext context, Handler<AsyncResult<List<User>>> resultHandler) {
		client.getConnection(res -> {
			if (res.succeeded()) {

				SQLConnection connection = res.result();

				connection.query("SELECT * FROM public.user", userAsyncResultHandler -> {
					if (userAsyncResultHandler.succeeded()) {
						List<User> users = new ArrayList<>();
						userAsyncResultHandler.result().getRows().forEach(json -> {
							User user = new User();
							user.setId(json.getLong("id"));
							user.setFirstName(json.getString("first_name"));
							user.setLastName(json.getString("last_name"));

							users.add(user);
						});
						resultHandler
								.handle(new AsyncResultBuilder<List<User>>().withSuccess().withResult(users).build());
					} else {
						resultHandler.handle(new AsyncResultBuilder<List<User>>().withFail()
								.withCause(userAsyncResultHandler.cause()).build());
					}
				});
			} else {
				System.out.println("No connection.");
			}
		});
	}

}
