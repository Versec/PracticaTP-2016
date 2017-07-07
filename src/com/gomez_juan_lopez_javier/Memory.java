package com.gomez_juan_lopez_javier;

/**
 * Clase Memory:
 * 
 * Representa la memoria de la maquina.
 * 
 * @author Juan Gomez
 * @author Javier Lopez
 * @version 3.0
 */

public class Memory {
	/**
	 * Maximo tamanio de la memoria.
	 */
	private final int MAX_MEMORY_SIZE = 10;
	
	/**
	 * Array de objetos {@link Integer} que representa la memoria.
	 */
	private Integer [] memory = new Integer [MAX_MEMORY_SIZE];
	
	/**
	 * Escribe en una posicion de memoria concreta el valor dado. Si esta posicion no es valida retornara false.
	 * 
	 * @param pos posicion de memoria en la que escribir.
	 * 
	 * @param value valor a escribir en memoria.
	 * 
	 * @return true si el valor se ha escrito de forma correcta, false en cualquier otro caso.
	 */
	public boolean write(int pos, int value){
		if(pos > memory.length){
			Integer [] auxMemory = new Integer [pos*2];
			System.arraycopy(memory, 0, auxMemory, 0, memory.length);
			this.memory = new Integer [pos*2];
			System.arraycopy(auxMemory, 0, memory, 0, auxMemory.length);
		}
		if(pos >=0){
			this.memory[pos] =  value;
			return true;
		}
		return false;
	}
	/**
	 * Lee la posicion de memoria.
	 * 
	 * @param pos posicion de la memoria a leer.
	 * @return valor en esa posicion de memoria. Puede ser null.
	 */
	public int read (int pos){
		return this.memory[pos];
	}
	
	/**
	 * Comprueba si una direccion de memoria esta vacia.
	 * 
	 * @param pos direccion de memoria a comprobar.
	 * 
	 * @return true si la direccion de memoria esta vacia, false si no esta vacia.
	 */
	public boolean isAddressEmpty(int pos){
		if(this.memory[pos] !=  null){
			return false;
		}
		return true;
	}
	
	/**
	 * Convierte a objeto {@link String} la posicion de memoria y lo que esta contenido en ella.
	 * 
	 * @return Cadena {@link String} que representa de la memoria.
	 */
	public String toString (){
		String s="<vacía>";
		
		for (int i = 0; i < memory.length; i++) {
			if (memory[i]!= null){
				s = "[" + i +"]: "+ memory [i] + " ";
			}
		}
		return s;
	}
}
