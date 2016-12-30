package com.gomez_juan_lopez_javier.instructions.one_paramater.conditional_jumps;

import com.gomez_juan_lopez_javier.ByteCode;

/**
 * Clase que implementa la instruccion IfEq. Compara los dos ultimos numeros en la pila de operandos
 * (borrandolos) y comprueba si son iguales. Si no es asi, el programa salta a la instruccion N. Si lo es
 * continua el flujo normal del programa.
 */

public class IfEq extends ConditionalJumps{

	public IfEq() {}

	public IfEq(int parseInt) {
		super(parseInt);
	}

	@Override
	public String toString() {
		return "IFEQ " + param;
	}

	@Override
	protected ByteCode parseAux(String instruc, String param) {
		if (instruc.equalsIgnoreCase("IFEQ") && param.matches("(\\+)?[0-9]+")){
			return new IfEq(Integer.parseInt(param));
		}
		else 
			return null;
	}

	@Override
	protected boolean compare(int cima, int subcima) {
		if(subcima == cima){
			return true;
		}
		return false;
	}
}
