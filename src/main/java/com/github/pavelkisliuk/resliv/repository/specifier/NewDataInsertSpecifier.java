package com.github.pavelkisliuk.resliv.repository.specifier;

import com.github.pavelkisliuk.resliv.entity.City;
import com.github.pavelkisliuk.resliv.entity.Message;
import com.github.pavelkisliuk.resliv.repository.CityRepository;
import com.github.pavelkisliuk.resliv.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class NewDataInsertSpecifier{
	private MessageRepository messageRepository;

	private CityRepository cityRepository;

	@Autowired
	public void setRepository(MessageRepository repository) {
		this.messageRepository = repository;
	}

	@Autowired
	public void setRepository(CityRepository repository) {
		this.cityRepository = repository;
	}

	@Transactional
	public void insert(Message message, List<String> cityList) {
		messageRepository.save(message);
		for(String cityName : cityList) {
			City newCity = new City();
			newCity.setMessageId(message.getId());
			newCity.setName(cityName.toUpperCase());
			cityRepository.save(newCity);
		}
	}
}