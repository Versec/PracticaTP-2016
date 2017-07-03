package com.gomez_juan_lopez_javier.instructions;

import com.gomez_juan_lopez_javier.LexicalParser;
import com.gomez_juan_lopez_javier.TermParser;
import com.gomez_juan_lopez_javier.exceptions.ArrayException;
import com.gomez_juan_lopez_javier.terms.Term;

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
	
	private String varName;
	private String operator;
	private Term term1, term2;

	public CompoundAssignment(String varName, Term rhs1, Term rhs2, String op) {
		this.varName = varName;
		this.term1 = rhs1;
		this.term2 = rhs2;
		this.operator = op;
	}

	public CompoundAssignment() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) {
		if (words.length != 5 )
			return null;
		if (!words[1].equals("="))
			return null;
		
		if(!words[3].equals("+") && !words[3].equals("-") 
				&& !words[3].equals("*") && !words[3].equals("/"))
			return null;
		
		Term rhs1 = TermParser.parse(words[2]);
		if (rhs1 == null)
			return null;
		
		Term rhs2 = TermParser.parse(words[4]);
		if (rhs2 == null)
			return null;
		//lexParser.increaseProgramCounter();
		return new CompoundAssignment (words[0], rhs1, rhs2, words[3]);
	}

	@Override
	public void Compile(Compiler compiler) throws ArrayException {
		// TODO Auto-generated method stub
		
	}

}
