package com.gomez_juan_lopez_javier.commands;

import com.gomez_juan_lopez_javier.Engine;

/**
 * Clase que implementa el comando Replace N. Reemplaza la instruccion en la linea N por una nueva 
 * introducida por el usuario. 
 */

public class Replace implements Command {
	
	private int instToReplace;
	
	public Replace() {
		super();
	}
	
	public Replace (int instToReplace){
		this.instToReplace = instToReplace;
	}

	@Override
	public boolean execute(Engine engine) {
		engine.ejecutarReplace(this.instToReplace);
		return true;
	}

	@Override
	public Command parse(String... line) {
		if (line.length==2 && line[0].equalsIgnoreCase("REPLACE") && line[1].matches("(\\+)?[0-9]+")){		
			return new Replace(Integer.parseInt(line[1]));
		}
		else 
			return null;
	}

	@Override
	public String textHelp() {
		return "REPLACE N: Reemplaza la instruccion N por la solicitada al usuario" + System.getProperty("line.separator");
	}

}
