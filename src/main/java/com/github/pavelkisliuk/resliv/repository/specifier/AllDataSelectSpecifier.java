package com.github.pavelkisliuk.resliv.repository.specifier;

import com.github.pavelkisliuk.resliv.command.Command;
import com.github.pavelkisliuk.resliv.entity.City;
import com.github.pavelkisliuk.resliv.entity.Message;
import com.github.pavelkisliuk.resliv.repository.CityRepository;
import com.github.pavelkisliuk.resliv.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AllDataSelectSpecifier {
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

	public Map<String, String> query() {
		Map<String, String> allData = new HashMap<>();
		List<Message> messageList = messageRepository.findAll();
		for(Message message : messageList) {
			List<City> cityList = cityRepository.findByMessageId(message.getId());
			allData.put(message.getMessage(), Command.GSON.toJson(cityList));
		}
		return allData;
	}
}