package ru.rsreu.Zhilenko0804.resourcer;

import java.util.ResourceBundle;

public class SqlQueriesManager {
	private final static ResourceBundle resourceBundle = ResourceBundle
			.getBundle("resources.sqlQueries");

	private SqlQueriesManager() {
	}

	public static String getProperty(String key) {
		return resourceBundle.getString(key);
	}
}
