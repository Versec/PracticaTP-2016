package com.gomez_juan_lopez_javier.commands;

import com.gomez_juan_lopez_javier.Engine;
import com.gomez_juan_lopez_javier.exceptions.ArrayException;
import com.gomez_juan_lopez_javier.exceptions.ExecutionErrorException;

/**
 * Clase que implementa el comando run. Este comando ejecutara el programa almacenado.
 */

public class Run implements Command {

	public Run() {
		super();
	}
	
	@Override
	public boolean execute(Engine engine) throws ExecutionErrorException, ArrayException {
		engine.ejecutarRun();
		return true;
	}

	@Override
	public Command parse(String... line) {
		if (line.length==1 && line[0].equalsIgnoreCase("RUN")){
			return new Run();
		}
		else 
			return null;
	}

	@Override
	public String textHelp() {
		return "RUN: Ejecuta el programa guardado." + System.getProperty("line.separator");
	}
}
