package com.github.pavelkisliuk.resliv.service;

import com.github.pavelkisliuk.resliv.entity.ReslivData;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ReslivService<T extends ReslivData, R extends ReslivData> {
	Optional<R> serve(T data);
}