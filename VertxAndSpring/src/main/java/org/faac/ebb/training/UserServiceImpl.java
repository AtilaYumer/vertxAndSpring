package org.faac.ebb.training;

import org.faac.ebb.training.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

import io.vertx.core.Vertx;
import io.vertx.ext.web.RoutingContext;

public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;
	
	@Override
	public void createUser() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void findUsers(RoutingContext context, Vertx vertx) {
		userDao.getUsers(context, vertx);
	}

}
