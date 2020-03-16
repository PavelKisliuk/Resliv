package com.github.pavelkisliuk.resliv.command;

public enum GetCommandType {
	ALL_DATA(AllDataCommand.of());

	private Command command;

	GetCommandType(Command command) {
		this.command = command;
	}

	public Command get() {
		return command;
	}
}
