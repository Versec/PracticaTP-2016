package com.gomez_juan_lopez_javier.instructions.one_paramater;

import com.gomez_juan_lopez_javier.ByteCode;
import com.gomez_juan_lopez_javier.CPU;

/**
 * Clase que implementa la instruccion Store. escribe en una posicion de memoria el contenido de la cima de 
 * la pila de operandos, y lo elimina de ella.
 */

public class Store extends ByteCodeOneParameter{

	public Store(){}
	
	public Store(int parseInt) {
		super(parseInt);
	}

	@Override
	protected ByteCode parseAux(String instruc, String param) {
		if (instruc.equalsIgnoreCase("STORE") && param.matches("(\\+)?[0-9]+")){
			return new Store(Integer.parseInt(param));
		}
		else 
			return null;
	}
	
	@Override
	public boolean execute(CPU cpu) {
		return cpu.store(this);
	}
	
	@Override
	public String toString() {
		return "STORE " + param;
	}
}
