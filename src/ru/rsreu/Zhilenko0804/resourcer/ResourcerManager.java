package ru.rsreu.Zhilenko0804.resourcer;

import java.util.ResourceBundle;

public class ResourcerManager {
	private final static ResourceBundle resourceBundle = ResourceBundle
			.getBundle("resources.text");

	private ResourcerManager() {
	}

	public static String getProperty(String key) {
		return resourceBundle.getString(key);
	}
}
