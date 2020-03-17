package com.github.pavelkisliuk.resliv.entity;

import com.github.pavelkisliuk.resliv.config.AppConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

public class BotProperty {
	private static final String PROPERTY_URL = "bot.properties";
	public static final BotProperty INSTANCE = new BotProperty();
	private Properties properties;

	private BotProperty() {
		if (INSTANCE != null) {
			throw new AssertionError("Attempt of creation second instance of BotProperty!!!");
		}
		Properties properties = new Properties();
		try (InputStream fileInputStream =
					 AppConfig.class.getClassLoader().getResourceAsStream(PROPERTY_URL)) {
			if (fileInputStream == null) {
				throw new AssertionError(
						"null input stream in BotProperty -> BotProperty().");
			}
			properties.load(fileInputStream);
		} catch (IOException e) {
			throw new AssertionError(
					"IOException in BotProperty -> BotProperty().");
		}
		this.properties = properties;
	}

	public Properties getProperties() {
		return properties;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		BotProperty that = (BotProperty) o;

		return Objects.equals(properties, that.properties);
	}

	@Override
	public int hashCode() {
		return properties != null ? properties.hashCode() : 0;
	}

	@Override
	public String toString() {
		return "BotProperty{" +
				"properties=" + properties +
				'}';
	}
}