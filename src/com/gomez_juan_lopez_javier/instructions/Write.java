package com.gomez_juan_lopez_javier.instructions;

import com.gomez_juan_lopez_javier.LexicalParser;
import com.gomez_juan_lopez_javier.TermParser;
import com.gomez_juan_lopez_javier.exceptions.ArrayException;
import com.gomez_juan_lopez_javier.terms.Term;

public class Write implements Instruction {
	
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
	public void Compile(Compiler compiler) throws ArrayException {
		// TODO Auto-generated method stub
		
	}

}
