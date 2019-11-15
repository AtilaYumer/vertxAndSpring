package org.faac.ebb.training;

import java.util.List;

import org.faac.ebb.training.config.AsyncResultBuilder;
import org.faac.ebb.training.dao.UserDao;
import org.faac.ebb.training.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;

public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public void createUser(RoutingContext context, Handler<AsyncResult<List<User>>> resultHandle) {
		// TODO Auto-generated method stub

	}

	@Override
	public void findUsers(RoutingContext context, Handler<AsyncResult<List<User>>> resultHandler) {
		userDao.getUsers(context, getUsersAsyncResultHandler -> {
			if (getUsersAsyncResultHandler.succeeded()) {
				resultHandler.handle(new AsyncResultBuilder<List<User>>()
						.withSuccess()
						.withResult(getUsersAsyncResultHandler.result())
						.build());
			} else {
				resultHandler.handle(new AsyncResultBuilder<List<User>>()
						.withFail()
						.withCause(getUsersAsyncResultHandler.cause())
						.build());
			}
		});
	}

}
