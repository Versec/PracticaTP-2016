package com.gomez_juan_lopez_javier.instructions.conditions;

import com.gomez_juan_lopez_javier.LexicalParser;
import com.gomez_juan_lopez_javier.terms.Term;

public class Less extends Condition {

	public Less(Term t1, Term t2) {
		this.term1 = t1;
		this.term2 = t2;
	}

	public Less() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Condition parseOp(Term t1, String op, Term t2, LexicalParser parser) {
	if(!op.equals("<"))
		return null;
	
	return new Less (t1, t2);
	}
}
