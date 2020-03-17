package com.github.pavelkisliuk.resliv.command;

import com.github.pavelkisliuk.resliv.entity.Message;
import com.github.pavelkisliuk.resliv.service.MessageUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class MessageUpdateCommand implements Command {
	private static MessageUpdateCommand messageUpdateCommand;

	private MessageUpdateService messageUpdateService;

	@Autowired
	public void setUpdateMessageCommand(MessageUpdateCommand messageUpdateCommand) {
		MessageUpdateCommand.messageUpdateCommand = messageUpdateCommand;
	}

	@Autowired
	public void setMessageUpdateService(MessageUpdateService messageUpdateService) {
		this.messageUpdateService = messageUpdateService;
	}

	static Command of() {
		return messageUpdateCommand;
	}

	@Override
	public Map<String, String> execute(Map<String, String> params) {
		Message newMessage = GSON.fromJson(params.get(KEY_DATA), Message.class);
		return messageUpdateService.serve(newMessage);
	}
}