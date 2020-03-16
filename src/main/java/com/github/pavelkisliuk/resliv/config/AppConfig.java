package com.github.pavelkisliuk.resliv.config;

import com.github.pavelkisliuk.resliv.entity.BotProperty;
import com.github.pavelkisliuk.resliv.entity.City;
import com.github.pavelkisliuk.resliv.entity.Message;
import com.github.pavelkisliuk.resliv.entity.ReslivString;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	@Bean
	public BotProperty botProperty() {
		return BotProperty.INSTANCE;
	}

	@Bean
	public ReslivString reslivString() {
		return new ReslivString();
	}

	@Bean
	public Message message() {
		return new Message();
	}

	@Bean
	public City city() {
		return new City();
	}
}