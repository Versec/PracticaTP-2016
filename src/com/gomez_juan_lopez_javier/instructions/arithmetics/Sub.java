package com.gomez_juan_lopez_javier.instructions.arithmetics;

import com.gomez_juan_lopez_javier.ByteCode;
import com.gomez_juan_lopez_javier.CPU;

/**
 * Clase que implementa la instruccion Sub. Resta los dos primeros numeros de la cima de la pila y vuelve a guardar el
 * resultado en la pila.
 */

public class Sub extends Arithmetics{

	@Override
	public ByteCode parse(String... line) {
		if (line.length==1 && line[0].equalsIgnoreCase("SUB")){
			return new Sub();
		}
		else 
			return null;
	}

	@Override
	public boolean execute(CPU cpu) {
		if(cpu.sub())
			return true;
		else	
			return false;
	}

	@Override
	public String toString() {
		return "Sub";
	}
}
