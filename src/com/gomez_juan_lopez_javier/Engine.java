package com.gomez_juan_lopez_javier;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.gomez_juan_lopez_javier.bytecode.ByteCode;
import com.gomez_juan_lopez_javier.commands.Command;
import com.gomez_juan_lopez_javier.exceptions.ArrayException;
import com.gomez_juan_lopez_javier.exceptions.DivByZeroException;
import com.gomez_juan_lopez_javier.exceptions.ExecutionErrorException;
import com.gomez_juan_lopez_javier.exceptions.LexicalAnalysisException;

/**
 * Clase Engine:
 * 
 * Motor encargado de controlar el programa.
 * 
 * @author Juan Gomez 
 * @author Javier Lopez
 * @version 3.0
 */

public class Engine {
	
	/**
	 * Representa un comando {@link Command}. 
	 */
	public Command comando;
	
	
	/**
	 * Representa una instruccion {@link ByteCode}.
	 */
	public ByteCode instruccion;
	
	
	/**
	 * Programa {@link ByteCodeProgram} a escribir por el usuario.
	 */
	private ByteCodeProgram byteCodeProgram;
	
	
	/**
	 * Primitiva boolean que indica si el engine {@link Engine} ha terminado.
	 */
	private boolean end;
	
	
	/**
	 * Objeto {@link CPU} que representa a la CPU que ejecuta laas instrucciones {@link ByteCode}.
	 */
	private CPU cpu;
	
	
	/**
	 * Objeto {@link java.util.Scanner} utilizado para leer los comandos introducidos por el usuario.
	 */
	private java.util.Scanner sc;
	
	
	/**
	 * Objeto {@link SourceProgram} utilizado para almacenar el programa fuente que se carga del fichero.
	 */
	private SourceProgram sProgram;
	
	
	/**
	 * Objeto {@link ParsedProgram} para almacenar el programa parseado.
	 */
	private ParsedProgram pProgram;
	
	/**
	 * Objeto {@link ByteCodeProgram} para almacenar el programa Bytecode.
	 */
	//private ByteCodeProgram bytecodeProgram;
	
	
	Compiler compiler;
	
	/**
	 * Constructor por defecto de {@link Engine}.
	 */
	public Engine (){
		this.end = false;
	}
	
	/**
	 * Inicia el motor {@link Engine} y lee los comandos introducidos y los parsea convenientemente. Si el comando
	 * introducido no es correcto se mostrara un error.
	 * @throws ExecutionErrorException 
	 * @throws ArrayException 
	 * @throws LexicalAnalysisException 
	 */
	public void start () throws ExecutionErrorException {
		this.byteCodeProgram = new ByteCodeProgram();
		this.cpu = new CPU();
		sc = new java.util.Scanner(System.in); 
		
		while(!this.end){
			System.out.print("> ");
			
			String cadenaComando = sc.nextLine();
			
			comando = CommandParser.parse(cadenaComando);
			
			if (comando != null) {
				try {
					comando.execute(this);
				} 
				catch(ExecutionErrorException e) {
					try {
						this.cpu.printErrorLine();
					} catch (ArrayException e1) {
						e1.printStackTrace();
					}
					System.out.println(e.getLocalizedMessage());
				}
				catch (ArrayException e) {
					System.out.println(e.getLocalizedMessage());
				}
				
				catch (LexicalAnalysisException e) {
					System.out.println(e.getLocalizedMessage());
				}
			}
			else {
				
				System.out.println(cadenaComando + ": No se encontro el comando");
				System.out.println();
			}
			if(sProgram != null){
				System.out.println("Programa fuente almacenado:");
				System.out.println(this.sProgram.toString());
			}
			if(byteCodeProgram != null) {
				System.out.println("Programa bytecode almacenado:");
				System.out.println(this.byteCodeProgram.toString());
			}
		}
		sc.close();
	}
	
	/**
	 * Metodo para mostrar ejecutar y mostrar HELP.
	 * 
	 * @return verdadero si ha mostrado la ayuda.
	 */
	public boolean ejecutarHelp() {
		System.out.println();
		CommandParser.showHelp();
		System.out.println();
		return true;
	}
	
	/**
	 * Metodo para ejecutar el comando RUN.
	 * @throws ExecutionErrorException 
	 * @throws ArrayException 
	 */
	public void ejecutarRun() throws ExecutionErrorException, ArrayException {
		this.cpu = new CPU();
		System.out.println("Comienza la ejecucion de RUN \n");
		this.cpu.programToCPU(byteCodeProgram);
		if(cpu.run()){
			System.out.println("El estado de la maquina tras ejecutar el programa es:");
			System.out.println(this.cpu.memoryToString());
			System.out.println(this.cpu.stackToString()+ "\n");
		}
	}
	
	/**
	 * Metodo para ejecutar el comando RESET.
	 */
	public void ejecutarReset() {
		System.out.println("Comienza la ejecucion de RESET");
		this.byteCodeProgram = new ByteCodeProgram();
	}
	
	/**
	 * Metodo para ejecutar el comando REPLACE.
	 * 
	 * @param lineToReplace Posicion en el programa de la instruccion {@link ByteCode} a reemplazar.
	 * @throws ArrayException 
	 */
	public void ejecutarReplace(int lineToReplace) throws ArrayException {
		System.out.println("Comienza la ejecucion de REPLACE");
		if(lineToReplace > byteCodeProgram.getProgramSize() || byteCodeProgram.readInstructionAt(lineToReplace)== null){
			throw new ArrayException ("Comando REPLACE ha fallado. La linea de instruccion indicada a substituir no"
					+ " es valida, o no existe ningun programa en memoria.");
		}
		else {
			System.out.println("Antigua instruccion en la linea " + lineToReplace + ": " 
					+ byteCodeProgram.readInstructionAt(lineToReplace).toString());
			System.out.print("Nueva instruccion? ");
			String newInstruction = sc.nextLine();
			ByteCode instruction = ByteCodeParser.parse(newInstruction);
			if(!byteCodeProgram.writeInstructionAt(instruction, lineToReplace)){
				throw new ArrayException ("Comando REPLACE ha fallado. La nueva instruccion no es valida.");
			}
		}
		System.out.println("Programa almacenado: ");
		System.out.println(this.byteCodeProgram.toString());
	}
	
	/**
	 * Metodo para ejecutar el comando QUIT y salir del programa.
	 */
	public void ejecutarQuit() {
		System.out.println("Fin de la ejecucion...");
		
		this.end = true;
	}
	
	/**
	 * Metodo para leer las instrucciones del programa.
	 * 
	 * @return true si la instruccion es correcta y la maquina ha podido guardarla correctamente. False en cualquier
	 * otro caso.
	 * @throws ArrayException 
	 */
	public boolean readByteCodeProgram() throws ArrayException {
		boolean end = false;
		
		while(!end){
			String cadenaBytecode = sc.nextLine();
			
			if (!cadenaBytecode.matches("end")) {
				instruccion = ByteCodeParser.parse(cadenaBytecode);
				
				if (instruccion != null){
					byteCodeProgram.writeNextInstruction(instruccion);
				}
				else{
					System.out.println("Instruccion incorrecta.");
				}
			}
			else
				end = true;
		}
		return true;
	}
	
	public void ejecutarCompile() throws LexicalAnalysisException{
		try {
			this.LexicalAnalysis();
			this.generateByteCode();
		} catch (LexicalAnalysisException | ArrayException e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
	
	
	private void generateByteCode () throws ArrayException, LexicalAnalysisException {
		this.compiler = new Compiler ();
		compiler.compile(pProgram);
		this.byteCodeProgram = compiler.getByteCode();
	}

	
	private void LexicalAnalysis() throws LexicalAnalysisException, ArrayException {
		pProgram = new ParsedProgram();
		//TODO ¿Qué pasa si sProgram es null? Revisar excepciones.
		LexicalParser lParser = new LexicalParser(sProgram);
		lParser.lexicalParser(pProgram, "end");
	}

	
	/**
	 * Metodo para cargar el programa fuente de un fichero.
	 * 
	 * @param fileName
	 * @return true si se ha cargado correctamente. False en caso contrario.
	 */
	public boolean ejecutarLoad(String fileName) throws ArrayException {
		Scanner sourceScanner = null;
		try {
			System.out.println("Comienza la ejecucion de LOAD " + fileName);
			sProgram = new SourceProgram();
			sourceScanner = new Scanner(new File (fileName));
			String lineProgram = "";
			
			while(sourceScanner.hasNextLine()){
				lineProgram = sourceScanner.nextLine();
				if(!sProgram.writeNextInstruction(lineProgram)){
					throw new ArrayException("Se ha llenado la memoria reservada para el programa fuente: \n"
							+ "MAX_PROGRAM_SIZE: " + this.sProgram.getMaxProgramSize());	
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado. Asegurese de que ha escrito el nombre del archivo de forma correcta y con su terminacion (.txt) \n");
			//e.printStackTrace();
		}
		finally{
		if  (sourceScanner!= null)
				sourceScanner.close();
		}
		return true;
	}
}
