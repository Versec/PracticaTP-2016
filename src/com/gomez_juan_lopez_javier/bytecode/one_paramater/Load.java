package com.gomez_juan_lopez_javier.bytecode.one_paramater;

import com.gomez_juan_lopez_javier.CPU;
import com.gomez_juan_lopez_javier.bytecode.ByteCode;

/**
 * Clase que implementa la instruccion Load N. Lee de la memoria el valor almacenado en la posicion de memoria N
 * y lo apila en la pila de operandos.
 */

public class Load extends ByteCodeOneParameter{
			
	public Load(){}
	
	public Load(int parseInt) {
		super(parseInt);
	}
	
	@Override
	protected ByteCode parseAux(String instruc, String param) {
		if (instruc.equalsIgnoreCase("LOAD") && param.matches("(\\+)?[0-9]+")){
			return new Load(Integer.parseInt(param));
		}
		else 
			return null;
	}

	@Override
	public boolean execute(CPU cpu) {
		if (cpu.load(this))
			return true;
		
		return false;
	}
	
	@Override
	public String toString() {
		return "LOAD " + param;
	}

	

}
