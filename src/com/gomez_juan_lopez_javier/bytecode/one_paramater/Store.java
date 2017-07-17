package com.gomez_juan_lopez_javier.bytecode.one_paramater;

import com.gomez_juan_lopez_javier.CPU;
import com.gomez_juan_lopez_javier.bytecode.ByteCode;
import com.gomez_juan_lopez_javier.exceptions.StackException;

/**
 * Clase que implementa la instruccion Store. Escribe en una posicion de memoria el contenido de la cima de 
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
	public boolean execute(CPU cpu) throws StackException {
		return cpu.store(this);
	}
	
	@Override
	public String toString() {
		return "STORE " + param;
	}
}
