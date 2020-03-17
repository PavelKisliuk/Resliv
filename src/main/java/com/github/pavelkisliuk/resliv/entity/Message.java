package com.github.pavelkisliuk.resliv.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "Messages")
public class Message implements ReslivData {
	private Long id;

	private String message;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "message_Id")
	public Long getId() {
		return id;
	}

	public void setId(Long messageId) {
		this.id = messageId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Message message1 = (Message) o;

		if (!Objects.equals(id, message1.id)) return false;
		return Objects.equals(message, message1.message);
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (message != null ? message.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Message{" +
				"id=" + id +
				", message='" + message + '\'' +
				'}';
	}
}