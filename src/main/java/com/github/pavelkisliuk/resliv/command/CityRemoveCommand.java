package com.github.pavelkisliuk.resliv.command;

import com.github.pavelkisliuk.resliv.entity.City;
import com.github.pavelkisliuk.resliv.service.CityRemoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
public class CityRemoveCommand implements Command {
	private static CityRemoveCommand cityRemoveCommand;

	private CityRemoveService cityRemoveService;

	@Autowired
	public void setCityRemoveCommand(CityRemoveCommand cityRemoveCommand) {
		CityRemoveCommand.cityRemoveCommand = cityRemoveCommand;
	}

	@Autowired
	public void setCityRemoveService(CityRemoveService cityRemoveService) {
		this.cityRemoveService = cityRemoveService;
	}

	static Command of() {
		return cityRemoveCommand;
	}

	@Override
	public Map<String, String> execute(Map<String, String> params) {
		List<City> cityList = Arrays.asList(GSON.fromJson(params.get(KEY_DATA), City[].class));
		return cityRemoveService.serve(cityList);
	}
}