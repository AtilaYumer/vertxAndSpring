package org.faac.ebb.training.db;

import io.vertx.ext.sql.SQLClient;

public class DbClient {
	
	private SQLClient client;

	public SQLClient getClient() {
		return client;
	}

	public void setClient(SQLClient client) {
		this.client = client;
	}
}
