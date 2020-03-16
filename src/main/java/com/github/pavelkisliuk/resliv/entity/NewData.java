package com.github.pavelkisliuk.resliv.entity;

import com.google.gson.annotations.Expose;

import java.util.List;
import java.util.Objects;

public class NewData {
	private String message;
	private List<String> cities;

	public NewData(String message, List<String> cities) {
		this.message = message;
		this.cities = cities;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getCities() {
		return cities;
	}

	public void setCities(List<String> cities) {
		this.cities = cities;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		NewData newData = (NewData) o;

		if (!Objects.equals(message, newData.message)) return false;
		return Objects.equals(cities, newData.cities);
	}

	@Override
	public int hashCode() {
		int result = message != null ? message.hashCode() : 0;
		result = 31 * result + (cities != null ? cities.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "NewData{" +
				"message='" + message + '\'' +
				", cities=" + cities +
				'}';
	}
}
