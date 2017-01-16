package com.gomez_juan_lopez_javier.terms;

import com.gomez_juan_lopez_javier.Compiler;
import com.gomez_juan_lopez_javier.bytecode.ByteCode;

public interface Term {
	Term parse(String term);
	ByteCode compile(Compiler compiler);
}
