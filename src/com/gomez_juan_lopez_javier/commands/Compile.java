package com.gomez_juan_lopez_javier.commands;

import com.gomez_juan_lopez_javier.Engine;
import com.gomez_juan_lopez_javier.exceptions.ArrayException;
import com.gomez_juan_lopez_javier.exceptions.LexicalAnalysisException;

/**
 ** Esta clase implementa el comando compile. Genera un programa parseado y posteriormente
 *	un programa Bytecode.
 */

public class Compile implements Command {

	public Compile() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Engine engine) throws LexicalAnalysisException, ArrayException {{
		engine.ejecutarCompile();
	}
	return false;
	}

	@Override
	public Command parse(String... line) {
		if (line.length==1 && line[0].equalsIgnoreCase("COMPILE")){
			return new Compile();
		}
		else 
			return null;
	}

	@Override
	public String textHelp() {
		return "COMPILE: Compila el programa fuente generando el bytecode asociado, y posteriormente lo ejecuta a "
				+ "través de la TPMV." + System.getProperty("line.separator");
	}

}
