package com.gomez_juan_lopez_javier.bytecode.one_paramater.conditional_jumps;

import com.gomez_juan_lopez_javier.bytecode.ByteCode;

/**
 * Clase que implementa la instruccion IfNeq. Compara los dos ultimos numeros en la pila de operandos
 * (borrandolos) y comprueba si no son iguales. Si no es asi, el prgrama salta a la instruccion N. Si lo es
 * continua el flujo normal del programa.
 */
public class IfNeq extends ConditionalJumps{

	public IfNeq() {}
	
	public IfNeq(int parseInt){
		super(parseInt);
	}

	@Override
	public String toString() {
		return "IFNEQ " + param;
	}

	@Override
	protected ByteCode parseAux(String instruc, String param) {
		if (instruc.equalsIgnoreCase("IFNEQ") && param.matches("(\\+)?[0-9]+")){
			return new IfNeq(Integer.parseInt(param));
		}
		else 
			return null;
	}

	@Override
	protected boolean compare(int cima, int subcima) {
		if(subcima != cima){
			return true;
		}
		return false;
	}

}
