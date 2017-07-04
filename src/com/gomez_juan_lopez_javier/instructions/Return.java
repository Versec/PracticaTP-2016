package com.gomez_juan_lopez_javier.instructions;

import com.gomez_juan_lopez_javier.LexicalParser;
import com.gomez_juan_lopez_javier.bytecode.Halt;
import com.gomez_juan_lopez_javier.exceptions.ArrayException;

/**
 * Clase Return:
 * 
 * Representa la sentencia return.
 * 
 * @author Juan Gomez
 * @author Javier Lopez
 * @version 3.0
 */

public class Return implements Instruction {

	public Return() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) {
		if (words.length != 1)
			return null;
		if (!words[0].equalsIgnoreCase("return"))
			return null;
		return new Return();
	}

	@Override
	public void compile(com.gomez_juan_lopez_javier.Compiler compiler) throws ArrayException {
		compiler.addByteCode(new Halt());
	}

}
