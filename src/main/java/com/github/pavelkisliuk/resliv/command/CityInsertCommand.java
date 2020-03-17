package com.github.pavelkisliuk.resliv.command;

import com.github.pavelkisliuk.resliv.entity.City;
import com.github.pavelkisliuk.resliv.service.CityInsertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CityInsertCommand implements Command {
	private static CityInsertCommand cityInsertCommand;

	private CityInsertService cityInsertService;

	@Autowired
	public void setAddCityCommand(CityInsertCommand cityInsertCommand) {
		CityInsertCommand.cityInsertCommand = cityInsertCommand;
	}

	@Autowired
	public void setCityInsertService(CityInsertService cityInsertService) {
		this.cityInsertService = cityInsertService;
	}

	static Command of() {
		return cityInsertCommand;
	}

	@Override
	public Map<String, String> execute(Map<String, String> params) {
		City newCity = GSON.fromJson(params.get(KEY_DATA), City.class);
		return cityInsertService.serve(newCity);
	}
}