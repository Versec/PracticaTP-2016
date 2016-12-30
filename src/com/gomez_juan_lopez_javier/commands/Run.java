package com.gomez_juan_lopez_javier.commands;

import com.gomez_juan_lopez_javier.Command;
import com.gomez_juan_lopez_javier.Engine;

/**
 * Clase que implementa el comando run. Este comando ejecutara el programa almacenado.
 */

public class Run extends Command{

	public Run() {
		super();
	}
	
	@Override
	public boolean execute(Engine engine) {
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
