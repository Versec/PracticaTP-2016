package com.gomez_juan_lopez_javier.bytecode.arithmetics;

import com.gomez_juan_lopez_javier.CPU;
import com.gomez_juan_lopez_javier.bytecode.ByteCode;

/**
 * Clase que implementa la instruccion Add. Suma los dos primeros numeros de la cima de la pila y vuelve a guardar el
 * resultado en la pila.
 */

public class Add extends Arithmetics{

	@Override
	public ByteCode parse(String... line) {
		if (line.length==1 && line[0].equalsIgnoreCase("ADD")){
			return new Add();
		}
		else 
			return null;
	}

	@Override
	public boolean execute(CPU cpu) {
		if (cpu.add())
			return true;
		else
			return false;
	}

	@Override
	public String toString() {
		return "ADD";
	
	}

}
