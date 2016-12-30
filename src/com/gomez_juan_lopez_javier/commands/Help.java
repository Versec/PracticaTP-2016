package com.gomez_juan_lopez_javier.commands;

import com.gomez_juan_lopez_javier.Command;
import com.gomez_juan_lopez_javier.Engine;

/**
 * Esta clase implementa el comando Help. Mostrara la ayuda de los comandos.
 */

public class Help extends Command{

	
	public Help() {
		super();
	}

	@Override
	public boolean execute(Engine engine) {
		return engine.ejecutarHelp();
	}

	@Override
	public Command parse(String... s) {
		if (s.length==1 && s[0].equalsIgnoreCase("HELP")){
			return new Help();
		}
		else 
			return null;
	}

	public String textHelp() {
		return "HELP: Muestra esta ayuda." + System.getProperty("line.separator");
	}

}
