package com.gomez_juan_lopez_javier.bytecode.one_paramater;

import com.gomez_juan_lopez_javier.CPU;
import com.gomez_juan_lopez_javier.bytecode.ByteCode;
import com.gomez_juan_lopez_javier.exceptions.StackException;

/**
 * Clase que implementa la instruccion Push. Escribe un entero en la pila de operandos.
 */

public class Push extends ByteCodeOneParameter {
	
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
	public boolean execute(CPU cpu) throws StackException {
		return cpu.push(this);
	}

	@Override
	public String toString() {
		return "PUSH " + param;
	}

}
