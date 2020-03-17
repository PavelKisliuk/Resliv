package com.github.pavelkisliuk.resliv.repository;

import com.github.pavelkisliuk.resliv.entity.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {
	List<Message> findAll();

	boolean existsMessageByMessage(String message);
}