package com.github.pavelkisliuk.resliv.command;

public enum GetCommandType {
	ALL_DATA(DataQueryCommand.of());

	private Command command;

	GetCommandType(Command command) {
		this.command = command;
	}

	public Command get() {
		return command;
	}
}
