package com.github.pavelkisliuk.resliv.tbot;

import com.github.pavelkisliuk.resliv.entity.BotProperty;
import com.github.pavelkisliuk.resliv.entity.City;
import com.github.pavelkisliuk.resliv.entity.Message;
import com.github.pavelkisliuk.resliv.entity.ReslivString;
import com.github.pavelkisliuk.resliv.service.CityQueryService;
import com.github.pavelkisliuk.resliv.service.MessageQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Optional;

@Component
public class TBot extends TelegramLongPollingBot {
	private static final String BOT_USERNAME = "bot.username";
	private static final String BOT_TOKEN = "bot.token";
	private static final String BOT_MESSAGE = "bot.message";

	private BotProperty botProperty;
	private ReslivString cityName;
	private CityQueryService cityQueryService;
	private MessageQueryService messageQueryService;

	@Autowired
	public void setBotProperty(BotProperty botProperty) {
		this.botProperty = botProperty;
	}

	@Autowired
	public void setCityName(ReslivString cityName) {
		this.cityName = cityName;
	}

	@Autowired
	public void setCityQueryService(CityQueryService cityQueryService) {
		this.cityQueryService = cityQueryService;
	}

	@Autowired
	public void setMessageQueryService(MessageQueryService messageQueryService) {
		this.messageQueryService = messageQueryService;
	}

	@Override
	public void onUpdateReceived(Update update) {
		String chatId = update.getMessage().getChatId().toString();
		String clientMessage = update.getMessage().getText().toUpperCase();

		String defaultMessage = botProperty.getProperties().getProperty(BOT_MESSAGE);
		cityName.setString(clientMessage);

		Optional<City> city = cityQueryService.serve(cityName);
		if (city.isEmpty()) {
			sendMsg(chatId, defaultMessage);
			return;
		}

		Optional<Message> message = messageQueryService.serve(city.get());
		if (message.isEmpty()) {
			sendMsg(chatId, defaultMessage);
			return;
		}

		sendMsg(chatId, message.get().getMessage());
	}

	public synchronized void sendMsg(String chatId, String s) {
		SendMessage sendMessage = new SendMessage();
		sendMessage.enableMarkdown(true);
		sendMessage.setChatId(chatId);
		sendMessage.setText(s);
		try {
			execute(sendMessage);
		} catch (TelegramApiException e) {
			//log.log(Level.ERROR, "Exception: ", e.toString());
		}
	}

	@Override
	public String getBotUsername() {
		return botProperty.getProperties().getProperty(BOT_USERNAME);
	}

	@Override
	public String getBotToken() {
		return botProperty.getProperties().getProperty(BOT_TOKEN);
	}
}