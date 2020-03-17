package com.github.pavelkisliuk.resliv.service;

import com.github.pavelkisliuk.resliv.repository.specifier.DataQuerySpecifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DataQueryService {
	private DataQuerySpecifier dataQuerySpecifier;

	@Autowired
	public void setDataQuerySpecifier(DataQuerySpecifier dataQuerySpecifier) {
		this.dataQuerySpecifier = dataQuerySpecifier;
	}

	public Map<String, String> serve() {
		return dataQuerySpecifier.query();
	}
}