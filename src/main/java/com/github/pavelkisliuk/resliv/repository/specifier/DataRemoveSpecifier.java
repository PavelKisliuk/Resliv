package com.github.pavelkisliuk.resliv.repository.specifier;

import com.github.pavelkisliuk.resliv.entity.Message;
import com.github.pavelkisliuk.resliv.repository.CityRepository;
import com.github.pavelkisliuk.resliv.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DataRemoveSpecifier {
	private MessageRepository messageRepository;
	private CityRepository cityRepository;

	@Autowired
	public void setMessageRepository(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}

	@Autowired
	public void setCityRepository(CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}

	@Transactional
	public void delete(Message message) {
		cityRepository.deleteAllByMessageId(message.getId());
		messageRepository.delete(message);
	}
}