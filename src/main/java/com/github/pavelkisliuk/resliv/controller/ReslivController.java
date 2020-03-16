package com.github.pavelkisliuk.resliv.controller;

import com.github.pavelkisliuk.resliv.command.Command;
import com.github.pavelkisliuk.resliv.command.GetCommandType;
import com.github.pavelkisliuk.resliv.command.PostCommandType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/start")
public class ReslivController {
	private static final String COMMAND = "command";


	@RequestMapping(method = RequestMethod.GET)
	public Map<String, String> get(@RequestParam Map<String, String> params) {
		Command command = GetCommandType.valueOf(params.get(COMMAND)).get();
		return command.execute(params);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Map<String, String> post(@RequestParam Map<String, String> params) {
		Command command = PostCommandType.valueOf(params.get(COMMAND)).get();
		return command.execute(params);
	}
}