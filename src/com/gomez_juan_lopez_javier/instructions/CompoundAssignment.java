package com.gomez_juan_lopez_javier.instructions;

import com.gomez_juan_lopez_javier.LexicalParser;
import com.gomez_juan_lopez_javier.exceptions.ArrayException;

/**
 * Clase CompoundAssignment:
 * 
 * Representa asignaciones de la forma Variable = Term ArithmeticOper Term
 * 
 * @author Juan Gomez
 * @author Javier Lopez
 * @version 3.0
 */

public class CompoundAssignment implements Instruction{

	public CompoundAssignment() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Compile(Compiler compiler) throws ArrayException {
		// TODO Auto-generated method stub
		
	}

}
