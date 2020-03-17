package com.github.pavelkisliuk.resliv.repository;

import com.github.pavelkisliuk.resliv.entity.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {
	Optional<City> findByName(String name);

	List<City> findByMessageIdOrderByName(Long id);

	boolean existsCityByName(String name);

	void deleteAllByMessageId(Long messageId);

	long countCitiesByMessageId(Long messageId);
}