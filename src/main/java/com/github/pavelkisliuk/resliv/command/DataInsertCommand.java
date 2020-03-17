package com.github.pavelkisliuk.resliv.command;

import com.github.pavelkisliuk.resliv.entity.NewData;
import com.github.pavelkisliuk.resliv.service.DataInsertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class DataInsertCommand implements Command {
	private static DataInsertCommand dataInsertCommand;

	private DataInsertService dataInsertService;

	@Autowired
	public void setAddDataPostCommand(DataInsertCommand dataInsertCommand) {
		DataInsertCommand.dataInsertCommand = dataInsertCommand;
	}

	@Autowired
	public void setDataInsertService(DataInsertService dataInsertService) {
		this.dataInsertService = dataInsertService;
	}

	static Command of() {
		return dataInsertCommand;
	}

	@Override
	public Map<String, String> execute(Map<String, String> params) {
		NewData newData = GSON.fromJson(params.get(KEY_DATA), NewData.class);
		return dataInsertService.serve(newData);
	}
}