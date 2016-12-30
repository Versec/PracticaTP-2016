package com.gomez_juan_lopez_javier;

import com.gomez_juan_lopez_javier.instructions.one_paramater.*;
import com.gomez_juan_lopez_javier.instructions.one_paramater.conditional_jumps.*;
import com.gomez_juan_lopez_javier.instructions.*;
import com.gomez_juan_lopez_javier.instructions.arithmetics.*;

/**
 * Clase ByteCodeParser:
 * 
 * Se encarga de parsear un String y convertirla en una instruccion {@link ByteCode} valida.
 * 
 * @author Juan Gomez
 * @author Javier Lopez
 * @version 2.0
 */

public class ByteCodeParser {
	
	/**
	 * Array constante de todas las instrucciones {@link ByteCode}.
	 */
	private final static ByteCode[] bytecodes ={new Push(), new Add(), new Div(), new Halt(), new IfEq(),
			new IfLe(), new IfLeq(), new IfNeq(), new Load(), new Mul(), new Out(), new Store(), new Sub(), new GoTo()};
	
	/**
	 * Crea una instruccion {@link ByteCode} para cada instruccion recorriendo el array.
	 * En caso de que la instruccion o su paramatro sean invalidos, 
	 * devolver un objeto {@link ByteCode} con valor null.
	 * 
	 * @param line La cadena que contiene la instruccion.
	 * 
	 * @return La instruccion {@link ByteCode} y su posible parametro.
	 */
	
	public static ByteCode parse (String line) {
		ByteCode instruccion = null;
		
		//Separa la cadena por espacios.
		String myArray[] = line.split(" ", 2);
		
		//Recorre el array hasta que se encuentre una instruccion valida o se exceda el numero de elementos.
		for (int i = 0; i < bytecodes.length; i++) {
			instruccion = bytecodes[i].parse(myArray);
			if (instruccion != null) {
				break;
			}
		}
		return instruccion;
	}
}
