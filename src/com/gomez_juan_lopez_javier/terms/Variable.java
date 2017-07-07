package com.gomez_juan_lopez_javier.terms;

import com.gomez_juan_lopez_javier.Compiler;
import com.gomez_juan_lopez_javier.bytecode.ByteCode;
import com.gomez_juan_lopez_javier.bytecode.one_paramater.Load;

public class Variable implements Term {

	private String varName;
	
	
	public Variable(String term) {
		this.varName = term;
	}

	@Override
	public Term parse(String term) {
		if(term.length()!= 1){
			return null;
		} 
		else {
			char name = term.charAt(0);
			if('a' <= name && name <= 'z'){
				return new Variable(term);
			}
		}
		return null;
	}

	@Override
	public ByteCode compile(Compiler compiler) {
		return new Load (compiler.getVarIndex(this.varName));
	}
	
	@Override
	public String toString (){
		return this.varName;
	}

}
