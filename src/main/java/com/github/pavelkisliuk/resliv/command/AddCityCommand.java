package com.github.pavelkisliuk.resliv.command;

import com.github.pavelkisliuk.resliv.entity.City;
import com.github.pavelkisliuk.resliv.service.AddCityInsertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class AddCityCommand implements Command {
	private static AddCityCommand addCityCommand;

	private AddCityInsertService addCityInsertService;

	@Autowired
	public void setAddCityCommand(AddCityCommand addCityCommand) {
		AddCityCommand.addCityCommand = addCityCommand;
	}

	@Autowired
	public void setAddCityInsertService(AddCityInsertService addCityInsertService) {
		this.addCityInsertService = addCityInsertService;
	}

	static Command of() {
		return addCityCommand;
	}

	@Override
	public Map<String, String> execute(Map<String, String> params) {
		City newCity = GSON.fromJson(params.get(KEY_NEW), City.class);
		return addCityInsertService.serve(newCity);
	}
}