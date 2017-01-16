package com.gomez_juan_lopez_javier.instructions;

import com.gomez_juan_lopez_javier.LexicalParser;
import com.gomez_juan_lopez_javier.TermParser;
import com.gomez_juan_lopez_javier.exceptions.ArrayException;
import com.gomez_juan_lopez_javier.terms.Term;

/**
 * Clase SimpleAssignment:
 * 
 * Almacena asignaciones simples de la forma Variable = Term.
 * 
 * @author Juan Gomez
 * @author Javier Lopez
 * @version 3.0
 */

public class SimpleAssignment implements Instruction {
	
	private String varName;
	
	private Term rhs;

	public SimpleAssignment(String varName, Term rhs) {
		this.varName = varName;
		this.rhs = rhs;
	}
	
	public SimpleAssignment() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) {
		if (words.length != 3 )
			return null;
		if (!words[1].equals("="))
			return null;
		Term rhs = TermParser.parse(words[2]);
		if (rhs == null)
			return null;
		//lexParser aumenta su contador 
		return new SimpleAssignment (words[0], rhs);
	}

	@Override
	public void Compile(Compiler compiler) throws ArrayException {
		// TODO Auto-generated method stub
		
	}

}
