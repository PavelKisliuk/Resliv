package com.github.pavelkisliuk.resliv.command;

import com.github.pavelkisliuk.resliv.entity.City;
import com.github.pavelkisliuk.resliv.entity.Message;
import com.github.pavelkisliuk.resliv.service.MessageUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UpdateMessageCommand implements Command {
	private static UpdateMessageCommand updateMessageCommand;

	private MessageUpdateService messageUpdateService;

	@Autowired
	public void setUpdateMessageCommand(UpdateMessageCommand updateMessageCommand) {
		UpdateMessageCommand.updateMessageCommand = updateMessageCommand;
	}

	@Autowired
	public void setMessageUpdateService(MessageUpdateService messageUpdateService) {
		this.messageUpdateService = messageUpdateService;
	}

	static Command of() {
		return updateMessageCommand;
	}

	@Override
	public Map<String, String> execute(Map<String, String> params) {
		Message newMessage = GSON.fromJson(params.get(KEY_NEW), Message.class);
		return messageUpdateService.serve(newMessage);
	}
}