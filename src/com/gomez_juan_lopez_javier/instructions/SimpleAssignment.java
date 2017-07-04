package com.gomez_juan_lopez_javier.instructions;

import com.gomez_juan_lopez_javier.Compiler;
import com.gomez_juan_lopez_javier.LexicalParser;
import com.gomez_juan_lopez_javier.TermParser;
import com.gomez_juan_lopez_javier.bytecode.ByteCode;
import com.gomez_juan_lopez_javier.bytecode.one_paramater.Push;
import com.gomez_juan_lopez_javier.bytecode.one_paramater.Store;
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
		//lexParser.increaseProgramCounter();
		return new SimpleAssignment (words[0], rhs);
	}

	@Override
	public void compile(Compiler compiler) throws ArrayException {
		ByteCode bytecode = this.rhs.compile(compiler);		
		compiler.addByteCode(bytecode);
		compiler.writeToVarTable(this.varName);
		compiler.addByteCode(new Store(compiler.getIndex(this.varName)));
	}


}
