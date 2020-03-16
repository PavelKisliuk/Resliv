package com.github.pavelkisliuk.resliv.command;

public enum PostCommandType {
	ADD_DATA(AddDataCommand.of());

	private Command command;

	PostCommandType(Command command) {
		this.command = command;
	}

	public Command get() {
		return command;
	}
}