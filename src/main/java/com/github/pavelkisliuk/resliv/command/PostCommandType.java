package com.github.pavelkisliuk.resliv.command;

public enum PostCommandType {
	ADD_DATA(DataInsertCommand.of()),
	ADD_CITY(CityInsertCommand.of()),
	UPDATE_MESSAGE(MessageUpdateCommand.of()),
	REMOVE_CITY(CityRemoveCommand.of()),
	REMOVE_DATA(DataRemoveCommand.of());

	private Command command;

	PostCommandType(Command command) {
		this.command = command;
	}

	public Command get() {
		return command;
	}
}