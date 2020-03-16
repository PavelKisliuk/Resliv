package com.github.pavelkisliuk.resliv.service;

import com.github.pavelkisliuk.resliv.entity.City;
import com.github.pavelkisliuk.resliv.entity.Message;
import com.github.pavelkisliuk.resliv.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MessageQueryService implements ReslivService<City, Message> {
	private MessageRepository repository;

	@Autowired
	public void setRepository(MessageRepository repository) {
		this.repository = repository;
	}

	@Override
	public Optional<Message> serve(City city) {
		return repository.findById(city.getMessageId());
	}
}