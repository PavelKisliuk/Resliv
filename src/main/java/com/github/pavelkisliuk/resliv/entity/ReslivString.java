package com.github.pavelkisliuk.resliv.entity;

import java.util.Objects;

public class ReslivString implements ReslivData {
	private String string;

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		ReslivString that = (ReslivString) o;

		return Objects.equals(string, that.string);
	}

	@Override
	public int hashCode() {
		return string != null ? string.hashCode() : 0;
	}

	@Override
	public String toString() {
		return string;
	}
}