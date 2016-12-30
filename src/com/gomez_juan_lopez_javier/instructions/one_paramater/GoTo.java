package com.gomez_juan_lopez_javier.instructions.one_paramater;

import com.gomez_juan_lopez_javier.ByteCode;
import com.gomez_juan_lopez_javier.CPU;

/**
 * Clase que implementa la instruccion GoTo. Cambia el contador del programa para que se ejecute a partir
 * de una instruccion N. 
 */

public class GoTo extends ByteCodeOneParameter {

	public GoTo(int parseInt) {
		super(parseInt);
	}

	public GoTo() {}

	@Override
	protected ByteCode parseAux(String instruc, String param) {
		if (instruc.equalsIgnoreCase("GOTO") && param.matches("(\\+)?[0-9]+")){
			return new GoTo(Integer.parseInt(param));
		}
		else 
			return null;
	}

	@Override
	public boolean execute(CPU cpu) {
		cpu.setProgramCounter(this.param-1);
		return true;
	}

	@Override
	public String toString() {
		return "GOTO " + param;
	}

}
