package com.gomez_juan_lopez_javier.instructions;

import com.gomez_juan_lopez_javier.LexicalParser;
import com.gomez_juan_lopez_javier.TermParser;
import com.gomez_juan_lopez_javier.bytecode.Out;
import com.gomez_juan_lopez_javier.bytecode.one_paramater.Load;
import com.gomez_juan_lopez_javier.exceptions.ArrayException;
import com.gomez_juan_lopez_javier.terms.Term;

public class Write implements Instruction {
	
	/**
	 * Variable a escribir.
	 */
	private Term varToWrite;
	
	
	public Write() {
		// TODO Auto-generated constructor stub
	}

	
	public Write(Term varToWrite) {
		this.varToWrite = varToWrite;
	}

	
	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) {
		if (words.length != 2)
			return null;
		Term varToWrite = TermParser.parse(words[1]);
		if(varToWrite == null)
			return null;
		return new Write(varToWrite);
	}

	@Override
	public void compile(com.gomez_juan_lopez_javier.Compiler compiler) throws ArrayException {
		compiler.addNextByteCode(new Load(compiler.getVarIndex(this.varToWrite.toString())));
		compiler.addNextByteCode(new Out());
		
	}

}
