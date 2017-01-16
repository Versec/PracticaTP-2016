package com.gomez_juan_lopez_javier.bytecode.one_paramater.conditional_jumps;

import com.gomez_juan_lopez_javier.bytecode.ByteCode;

/**
 * Clase que implementa la instruccion IfEq. Compara los dos ultimos numeros en la pila de operandos
 * (borrandolos) y comprueba si la subcima es menor o igual a la cima. Si no es asi, el programa salta a la instruccion N. 
 * Si lo es continua el flujo normal del programa.
 */
public class IfLeq extends ConditionalJumps{

	public IfLeq() {}
	
	public IfLeq (int parseInt){
		super(parseInt);
	}

	@Override
	public String toString() {
		return "IFLEQ " + param;
	}

	@Override
	protected ByteCode parseAux(String instruc, String param) {
		if (instruc.equalsIgnoreCase("IFLEQ") && param.matches("(\\+)?[0-9]+")){
			return new IfLeq(Integer.parseInt(param));
		}
		else 
			return null;
	}

	@Override
	protected boolean compare(int cima, int subcima) {
		if(subcima <= cima){
			return true;
		}
		return false;
	}

}
