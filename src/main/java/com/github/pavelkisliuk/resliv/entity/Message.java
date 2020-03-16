package com.github.pavelkisliuk.resliv.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
}