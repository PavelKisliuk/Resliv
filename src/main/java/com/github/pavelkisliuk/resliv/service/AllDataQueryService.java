package com.github.pavelkisliuk.resliv.service;

import com.github.pavelkisliuk.resliv.repository.specifier.AllDataSelectSpecifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AllDataQueryService {
	private AllDataSelectSpecifier allDataSelectSpecifier;

	@Autowired
	public void setAllDataSelectSpecifier(AllDataSelectSpecifier allDataSelectSpecifier) {
		this.allDataSelectSpecifier = allDataSelectSpecifier;
	}

	public Map<String, String> serve() {
		return allDataSelectSpecifier.query();
	}
}