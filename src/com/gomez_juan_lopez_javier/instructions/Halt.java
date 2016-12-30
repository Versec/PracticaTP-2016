package com.gomez_juan_lopez_javier.instructions;

import com.gomez_juan_lopez_javier.ByteCode;
import com.gomez_juan_lopez_javier.CPU;

/**
 * Clase que implementa la instruccion Halt. Al ejecutarse esta instruccion, la CPU finaliza la ejecucion del programa.
 */

public class Halt extends ByteCode{

	@Override
	public ByteCode parse(String... line) {
		if (line.length==1 && line[0].equalsIgnoreCase("HALT")){
			return new Halt();
		}
		else 
			return null;
	}

	@Override
	public boolean execute(CPU cpu) {
		cpu.halt();
		return true;
	}

	@Override
	public String toString() {
		return "HALT";
	}
}
