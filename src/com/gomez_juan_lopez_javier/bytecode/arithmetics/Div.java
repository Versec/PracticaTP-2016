package com.gomez_juan_lopez_javier.bytecode.arithmetics;

import com.gomez_juan_lopez_javier.CPU;
import com.gomez_juan_lopez_javier.bytecode.ByteCode;

/**
 * Clase que implementa la instruccion Div. Divide los dos primeros numeros de la cima de la pila (si el denominador es 
 * distinto de 0) y vuelve a guardar el resultado en la pila.
 */

public class Div extends Arithmetics{

	@Override
	public ByteCode parse(String... line) {
		if (line.length==1 && line[0].equalsIgnoreCase("DIV")){
			return new Div();
		}
		else 
			return null;
	}

	@Override
	public boolean execute(CPU cpu) {
		if (cpu.div())
			return true;
		else
			return false;
	}

	@Override
	public String toString() {
		return "Div";
	}

}
