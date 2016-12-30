package com.gomez_juan_lopez_javier;

public interface Term {
	Term parse(String term);
	ByteCode compile(Compiler compiler);
}
