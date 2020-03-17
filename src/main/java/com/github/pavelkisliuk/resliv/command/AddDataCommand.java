package com.github.pavelkisliuk.resliv.command;

import com.github.pavelkisliuk.resliv.entity.NewData;
import com.github.pavelkisliuk.resliv.service.AddDataInsertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class AddDataCommand implements Command {
	private static AddDataCommand addDataCommand;

	private AddDataInsertService addDataInsertService;

	@Autowired
	public void setAddDataPostCommand(AddDataCommand addDataCommand) {
		AddDataCommand.addDataCommand = addDataCommand;
	}

	@Autowired
	public void setAddDataInsertService(AddDataInsertService addDataInsertService) {
		this.addDataInsertService = addDataInsertService;
	}

	static Command of() {
		return addDataCommand;
	}

	@Override
	public Map<String, String> execute(Map<String, String> params) {
		NewData newData = GSON.fromJson(params.get(KEY_NEW), NewData.class);
		return addDataInsertService.serve(newData);
	}
}