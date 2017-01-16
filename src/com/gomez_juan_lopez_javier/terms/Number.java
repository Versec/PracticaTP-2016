package com.gomez_juan_lopez_javier.terms;

import com.gomez_juan_lopez_javier.Compiler;
import com.gomez_juan_lopez_javier.bytecode.ByteCode;

public class Number implements Term {
	
	private int Num;
	public Number(int i){
		this.Num = i;
	}
	
	@Override
	public Term parse(String term) {
		// TODO Auto-generated method stub
		return new Number(Integer.parseInt(term));
	}

	@Override
	public ByteCode compile(Compiler compiler) {
		// TODO Auto-generated method stub
		return null;
	}

}
