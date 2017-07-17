package com.gomez_juan_lopez_javier.bytecode.one_paramater.conditional_jumps;

import com.gomez_juan_lopez_javier.CPU;
import com.gomez_juan_lopez_javier.bytecode.one_paramater.ByteCodeOneParameter;
import com.gomez_juan_lopez_javier.exceptions.StackException;

/**
 * Clase que representa las instrucciones de salto condicional. 
 */

public abstract class ConditionalJump extends ByteCodeOneParameter{

	public ConditionalJump() {		
	}

	
	public ConditionalJump(int parseInt) {
		super(parseInt);
	}

	@Override
	public boolean execute(CPU cpu) throws StackException {
		if(cpu.getStackSize()>=2){
			int cima = cpu.pop();
			int subcima = cpu.pop();
			if(compare(cima, subcima)){
				//No hacer nada e ir a la siguiente instruccion (PC+1)
			}
			else {
				cpu.setProgramCounter(this.param-1);
			}
			return true;
		}
		return false;
	}

	/**
	 * Compara la cima y subcima para probar si la condicion se cumple.
	 * @param cima operando cima de la pila.
	 * @param subcima operando subcima de la pila.
	 * @return true si la condicion se cumple. False en caso contrario.
	 */
	abstract protected boolean compare(int cima, int subcima);

}
