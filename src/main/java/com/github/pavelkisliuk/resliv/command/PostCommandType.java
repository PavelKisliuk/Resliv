package com.github.pavelkisliuk.resliv.command;

public enum PostCommandType {
	ADD_DATA(AddDataCommand.of()),
	ADD_CITY(AddCityCommand.of()),
	UPDATE_MESSAGE(UpdateMessageCommand.of()),
	REMOVE_CITY(CityRemoveCommand.of());

	private Command command;

	PostCommandType(Command command) {
		this.command = command;
	}

	public Command get() {
		return command;
	}
}