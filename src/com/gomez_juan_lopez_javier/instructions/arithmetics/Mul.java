package com.gomez_juan_lopez_javier.instructions.arithmetics;

import com.gomez_juan_lopez_javier.ByteCode;
import com.gomez_juan_lopez_javier.CPU;

/**
 * Clase que implementa la instruccion Mul. Multiplica los dos números de la cima de la pila y vuelve a guardar el
 * resultado en la pila.
 **/

public class Mul extends Arithmetics{

	@Override
	public ByteCode parse(String... line) {
		if (line.length==1 && line[0].equalsIgnoreCase("MUL")){
			return new Mul();
		}
		else 
			return null;
	}

	@Override
	public boolean execute(CPU cpu) {
		if (cpu.mul())
			return true;
		else
			return false;
	}

	@Override
	public String toString() {
		return "Mul";
	}

}
