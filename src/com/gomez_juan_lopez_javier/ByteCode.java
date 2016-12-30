package com.gomez_juan_lopez_javier;

/**
 * Clase abstracta Bytecode:
 * 
 * Representa las instrucciones bytecode que maneja el programa.
 * 
 * @author Juan Gomez
 * @author Javier Lopez
 * @version 2.0
 */

public abstract class ByteCode {
	
	/**
	 * Crea una instruccion {@link ByteCode} para cada instruccion. En caso de que la instruccion o su parametro sean 
	 * invalidos, devolver un objeto {@link ByteCode} con valor null.
	 * 
	 * @param line La cadena que contiene la instruccion.
	 * 
	 * @return La instruccion {@link ByteCode} y su posible parametro.
	 */
	public abstract ByteCode parse(String... line);
	
	
	/**
	 * Ejecuta una instruccion {@link ByteCode}. Devolvera true si la instruccion se ejecuta correctamente.
	 * En cualquier otro caso, devolvera false.
	 * 
	 * @param cpu La CPU de lamáquina virtual.
	 * 
	 * @return true si la instruccion se ha ejecutado correctamente. Si no es el caso, false.
	 */
	public abstract boolean execute(CPU cpu);
	
	/**
	 * Devuelve una representacion como String de la isntruccion {@link ByteCode}.
	 * 
	 * @return Representación de la instruccion en un objeto {@link String}
	 */
	public abstract String toString();
	
}
