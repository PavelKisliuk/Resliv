package com.github.pavelkisliuk.resliv.command;

import com.github.pavelkisliuk.resliv.service.AllDataQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class AllDataCommand implements Command {
	private static AllDataCommand allDataCommand;

	private AllDataQueryService allDataQueryService;

	@Autowired
	public void setAddDataPostCommand(AllDataCommand allDataCommand) {
		AllDataCommand.allDataCommand = allDataCommand;
	}

	@Autowired
	public void setAllDataQueryService(AllDataQueryService allDataQueryService) {
		this.allDataQueryService = allDataQueryService;
	}

	static Command of() {
		return allDataCommand;
	}

	@Override
	public Map<String, String> execute(Map<String, String> params) {
		return allDataQueryService.serve();
	}
}