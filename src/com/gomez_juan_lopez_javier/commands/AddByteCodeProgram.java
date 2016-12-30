package com.gomez_juan_lopez_javier.commands;

import com.gomez_juan_lopez_javier.Command;
import com.gomez_juan_lopez_javier.Engine;

/**
 * Esta clase implementa el comando Bytecode. Se encarga de almacenar en memoria las instrucciones
 * escritas por el usuario.
 */

public class AddByteCodeProgram extends Command{

	public AddByteCodeProgram() {
		super();
	}

	@Override
	public boolean execute(Engine engine) {
		engine.ejecutarAddByteCode();
		return true;
	}

	@Override
	public Command parse(String... line) {
		if (line.length==1 && line[0].equalsIgnoreCase("BYTECODE")){
			return new AddByteCodeProgram();
		}
		else 
			return null;
	}
	
	@Override
	public String textHelp() {
		return "BYTECODE: Permite al usuario introducir en orden las distintas instrucciones que componen un programa bytecode."
				+ System.getProperty("line.separator")
				+ "          "
				+"Presione ENTER después de escribir cada instrucción."
				+System.getProperty("line.separator")
				+ "          "
				+"Siquiere finalizar su programa, escriba END y presione ENTER."
				+System.getProperty("line.separator");
	}

}
