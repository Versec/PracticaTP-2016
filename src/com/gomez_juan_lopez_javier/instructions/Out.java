package com.gomez_juan_lopez_javier.instructions;

import com.gomez_juan_lopez_javier.ByteCode;
import com.gomez_juan_lopez_javier.CPU;

/**
 * Clase que implementa la instruccion Out. Escribe el entero almacenado en la pila de la cima. 
 */

public class Out extends ByteCode{

	@Override
	public ByteCode parse(String... line) {
		if (line.length==1 && line[0].equalsIgnoreCase("OUT")){
			return new Out();
		}
		else 
			return null;
	}

	@Override
	public boolean execute(CPU cpu) {
		if (cpu.out())
			return true;
		else 
			return false;
	}

	@Override
	public String toString() {
		return "OUT";
	}

}
