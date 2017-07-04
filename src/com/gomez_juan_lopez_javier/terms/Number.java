package com.gomez_juan_lopez_javier.terms;

import com.gomez_juan_lopez_javier.Compiler;
import com.gomez_juan_lopez_javier.bytecode.ByteCode;
import com.gomez_juan_lopez_javier.bytecode.one_paramater.Push;

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
		ByteCode bc = new Push (this.Num);
		return bc;
	}

}
