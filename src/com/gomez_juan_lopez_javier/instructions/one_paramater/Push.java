package com.gomez_juan_lopez_javier.instructions.one_paramater;

import com.gomez_juan_lopez_javier.ByteCode;
import com.gomez_juan_lopez_javier.CPU;

/**
 * Clase que implementa la instruccion Push. Escribe un entero en la pila de operandos.
 */

public class Push extends ByteCodeOneParameter{
	
	public Push(){}
	
	public Push(int parseInt) {
		super(parseInt);
	}
	
	@Override
	protected ByteCode parseAux(String instruc, String param) {
		if (instruc.equalsIgnoreCase("PUSH") && param.matches("(\\+|-)?[0-9]+")){
			//param = Integer.parseInt(line[1]);
			return new Push(Integer.parseInt(param));
		}
		else 
			return null;
	}

	@Override
	public boolean execute(CPU cpu) {
		return cpu.push(this);
	}

	@Override
	public String toString() {
		return "PUSH " + param;
	}

}
