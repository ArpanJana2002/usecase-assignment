package com.sel.auto.seleniumtuit;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DatabaseConfig {
	private static Properties props = new Properties();

	static {
		try (InputStream input = DatabaseConfig.class.getClassLoader().getResourceAsStream("database.properties")) {

			if (input != null) {
				props.load(input);
			} else {
				System.out.println("Sorry, unable to find database.properties");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getDB_URL() {
		String url = props.getProperty("DB_URL");
		if (url == null || url.trim().isEmpty()) {
			throw new IllegalStateException("DB_URL not found in database.properties");
		}
		return url;
	}

	public static String getDB_USER() {
		String user = props.getProperty("DB_USER");
		if (user == null || user.trim().isEmpty()) {
			throw new IllegalStateException("DB_USER not found in database.properties");
		}
		return user;
	}

	public static String getDB_PASSWORD() {
		return props.getProperty("DB_PASSWORD");
	}
}
