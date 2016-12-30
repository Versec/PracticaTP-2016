package com.gomez_juan_lopez_javier.commands;

import com.gomez_juan_lopez_javier.Command;
import com.gomez_juan_lopez_javier.Engine;

/**
 * Representa el comando load. Se encarga de cargar un fichero.
 */

public class LoadFich extends Command {

	public LoadFich() {
		super();
	}

	@Override
	public boolean execute(Engine engine) {
		return (engine.ejecutarLoad());
	}

	@Override
	public Command parse(String... line) {
		if (line.length==1 && line[0].equalsIgnoreCase("LOAD")){
			return new LoadFich();
		}
		else 
			return null;
	}

	@Override
	public String textHelp() {
		return "LOAD: Carga el fichero como programa fuente. No realiza ningún tipo de comprobación sintáctica."
				+ System.getProperty("line.separator");
	}

}
