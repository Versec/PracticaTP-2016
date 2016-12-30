package com.gomez_juan_lopez_javier.commands;

import com.gomez_juan_lopez_javier.Command;
import com.gomez_juan_lopez_javier.Engine;

/**
 * Clase que implementa el comando reset. Borrara el programa almacenado.
 */

public class Reset extends Command {

	public Reset() {
		super();
	}

	public boolean execute(Engine engine){ 
		engine.ejecutarReset();
		return true;
	}

	@Override
	public Command parse(String... line) {
		if (line.length==1 && line[0].equalsIgnoreCase("RESET")){
			return new Reset();
		}
		else 
			return null;
	}

	@Override
	public String textHelp() {
		return "RESET: Vacia el programa actual" + System.getProperty("line.separator");
	}

}
