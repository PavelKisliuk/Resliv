package com.github.pavelkisliuk.resliv.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "Cities")
public class City implements ReslivData {
	private Long id;

	private String name;

	private Long messageId;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "city_Id")
	public Long getId() {
		return id;
	}

	public void setId(Long cityId) {
		this.id = cityId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getMessageId() {
		return messageId;
	}

	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		City city = (City) o;

		if (!Objects.equals(id, city.id)) return false;
		if (!Objects.equals(name, city.name)) return false;
		return Objects.equals(messageId, city.messageId);
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (messageId != null ? messageId.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "City{" +
				"id=" + id +
				", name='" + name + '\'' +
				", messageId=" + messageId +
				'}';
	}
}