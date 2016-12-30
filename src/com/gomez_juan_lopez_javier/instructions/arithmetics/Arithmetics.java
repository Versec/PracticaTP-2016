package com.gomez_juan_lopez_javier.instructions.arithmetics;

import com.gomez_juan_lopez_javier.ByteCode;
import com.gomez_juan_lopez_javier.CPU;

/**
 * Clase para representar los comandos relacionados con la aritmetica.
 */

public abstract class Arithmetics extends ByteCode{

	@Override
	public abstract ByteCode parse(String... line);

	@Override
	public abstract boolean execute(CPU cpu);
	
}
