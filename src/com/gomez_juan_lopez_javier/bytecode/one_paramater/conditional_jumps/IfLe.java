package com.gomez_juan_lopez_javier.bytecode.one_paramater.conditional_jumps;

import com.gomez_juan_lopez_javier.bytecode.ByteCode;

/**
 * Clase que implementa la instruccion IfLe. Compara los dos ultimos numeros en la pila de operandos
 * (borrandolos) y comprueba si la subcima es menor que la cima. De ser asi se ejecutara la siguiente 
 * instruccion. Si no lo es, se ejecutara la instruccion N.
 */

public class IfLe extends ConditionalJumps{

	public IfLe() {}
	
	public IfLe(int parseInt) {
		super(parseInt);
	}

	@Override
	public String toString() {
		return "IFLE " + param;
	}

	@Override
	protected ByteCode parseAux(String instruc, String param) {
		if (instruc.equalsIgnoreCase("IFLE") && param.matches("(\\+)?[0-9]+")){
			return new IfLe(Integer.parseInt(param));
		}
		else 
			return null;
	}

	@Override
	protected boolean compare(int cima, int subcima) {
		if(subcima < cima){
			return true;
		}
		return false;
	}

}
