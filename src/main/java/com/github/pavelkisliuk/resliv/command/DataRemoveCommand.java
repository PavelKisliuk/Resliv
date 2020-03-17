package com.github.pavelkisliuk.resliv.command;

import com.github.pavelkisliuk.resliv.entity.Message;
import com.github.pavelkisliuk.resliv.service.DataRemoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class DataRemoveCommand implements Command {
	private static DataRemoveCommand dataRemoveCommand;

	private DataRemoveService dataRemoveService;

	@Autowired
	public void setDataRemoveCommand(DataRemoveCommand dataRemoveCommand) {
		DataRemoveCommand.dataRemoveCommand = dataRemoveCommand;
	}

	@Autowired
	public void setDataRemoveService(DataRemoveService dataRemoveService) {
		this.dataRemoveService = dataRemoveService;
	}

	static Command of() {
		return dataRemoveCommand;
	}

	@Override
	public Map<String, String> execute(Map<String, String> params) {
		Message message = GSON.fromJson(params.get(KEY_NEW), Message.class);
		return dataRemoveService.serve(message);
	}
}