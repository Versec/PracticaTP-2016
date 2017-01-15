package com.gomez_juan_lopez_javier.commands;

import com.gomez_juan_lopez_javier.Engine;
import com.gomez_juan_lopez_javier.exceptions.ArrayException;

/**
 * Representa el comando load. Se encarga de cargar un fichero.
 */

public class LoadFich implements Command {

	private String fileName;
	
	public LoadFich() {
		super();
	}
	
	public LoadFich(String fileName){
		this.fileName = fileName;
	}
	
	@Override
	public boolean execute(Engine engine) throws ArrayException {
		return (engine.ejecutarLoad(this.fileName));
	}

	@Override
	public Command parse(String... line) {
		if (line.length==2 && line[0].equalsIgnoreCase("LOAD")&& line[1].matches(".+")){
			return new LoadFich(line[1]);
		}
		else 
			return null;
	}

	@Override
	public String textHelp() {
		return "LOAD FICH: Carga el fichero FICH como programa fuente. No realiza ningún tipo de comprobación sintáctica."
				+ System.getProperty("line.separator");
	}

}
