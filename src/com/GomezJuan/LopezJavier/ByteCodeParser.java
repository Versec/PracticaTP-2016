package com.GomezJuan.LopezJavier;

/**
 * Clase ByteCodeParser:
 * 
 * Se encarga de parsear un String y convertirla en una instruccion {@link ByteCode} valida.
 * 
 * @author Juan Gomez
 * @author Javier Lopez
 * @version 1.0
 */

public class ByteCodeParser {
	
	/**
	 * Crea una instruccion {@link ByteCode} para cada instruccion. En caso de que la instruccion o su paramatro sean 
	 * invalidos, devolver un objeto {@link ByteCode} con valor null.
	 * 
	 * @param s La cadena que contiene la instruccion.
	 * 
	 * @return La instruccion {@link ByteCode} y su posible parametro.
	 */
	
	public static ByteCode parse (String s){
		ByteCode instruccion = null;
		s = s.toLowerCase();
		String myArray[] = s.split(" ", 2);
		
		if(s.matches("push "+"(\\+|-)?[0-9]+")){	
			instruccion = new ByteCode(ENUM_BYTECODE.PUSH, Integer.parseInt(myArray[1]));
			return instruccion;
		}
		if(s.matches("load "+"(\\+)?[0-9]+")){
			//Regex ligeramente diferente para evitar que acepte parámetros negativos
			instruccion = new ByteCode(ENUM_BYTECODE.LOAD, Integer.parseInt(myArray[1]));
			return instruccion;
		}
		if(s.matches("store "+"(\\+)?[0-9]+")){
			instruccion = new ByteCode(ENUM_BYTECODE.STORE, Integer.parseInt(myArray[1]));
			return instruccion;
		}
		if(s.matches("add")){
			instruccion = new ByteCode(ENUM_BYTECODE.ADD);
			return instruccion;
		}
		if(s.matches("sub")){
			instruccion = new ByteCode(ENUM_BYTECODE.SUB);
			return instruccion;
		}
		if(s.matches("mul")){
			instruccion = new ByteCode(ENUM_BYTECODE.MUL);
			return instruccion;
		}
		if(s.matches("div")){
			instruccion = new ByteCode(ENUM_BYTECODE.DIV);
			return instruccion;
		}
		if(s.matches("out")){
			instruccion = new ByteCode(ENUM_BYTECODE.OUT);
			return instruccion;
		}
		if(s.matches("halt")){
			instruccion = new ByteCode(ENUM_BYTECODE.HALT);
			return instruccion;
		}
		return instruccion;
	}
}
