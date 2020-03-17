package com.github.pavelkisliuk.resliv.command;

import com.google.gson.Gson;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public interface Command {
	Gson GSON = new Gson();
	String KEY_DATA = "data";
	Map<String, String> execute(Map<String, String> params);
}
