package com.gomez_juan_lopez_javier.bytecode.arithmetics;

import com.gomez_juan_lopez_javier.CPU;
import com.gomez_juan_lopez_javier.bytecode.ByteCode;
import com.gomez_juan_lopez_javier.exceptions.DivByZeroException;
import com.gomez_juan_lopez_javier.exceptions.ExecutionErrorException;

/**
 * Clase para representar los comandos relacionados con la aritmetica.
 */

public abstract class Arithmetics extends ByteCode{

	@Override
	public abstract ByteCode parse(String... line);

	@Override
	public abstract boolean execute(CPU cpu) throws ExecutionErrorException;
	
}
