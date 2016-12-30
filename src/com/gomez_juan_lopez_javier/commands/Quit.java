package com.gomez_juan_lopez_javier.commands;

import com.gomez_juan_lopez_javier.Command;
import com.gomez_juan_lopez_javier.Engine;

/**
 * Clase que implementa el comando Quit. Este comando finaliza el programa.
 */

public class Quit  extends Command{

	public Quit() {
		super();
	}

	@Override
	public boolean execute(Engine engine) {
		engine.ejecutarQuit();
		return true;
	}

	@Override
	public Command parse(String... line) {
		if (line.length==1 && line[0].equalsIgnoreCase("QUIT")){
			return new Quit();
		}
		else 
			return null;
	}

	@Override
	public String textHelp() {
		return "QUIT: Cierra la aplicacion" + System.getProperty("line.separator");
	}

}
