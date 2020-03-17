package com.github.pavelkisliuk.resliv.command;

import com.github.pavelkisliuk.resliv.service.DataQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class DataQueryCommand implements Command {
	private static DataQueryCommand dataQueryCommand;

	private DataQueryService dataQueryService;

	@Autowired
	public void setAddDataPostCommand(DataQueryCommand dataQueryCommand) {
		DataQueryCommand.dataQueryCommand = dataQueryCommand;
	}

	@Autowired
	public void setDataQueryService(DataQueryService dataQueryService) {
		this.dataQueryService = dataQueryService;
	}

	static Command of() {
		return dataQueryCommand;
	}

	@Override
	public Map<String, String> execute(Map<String, String> params) {
		return dataQueryService.serve();
	}
}