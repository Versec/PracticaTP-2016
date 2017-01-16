package com.gomez_juan_lopez_javier;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.gomez_juan_lopez_javier.bytecode.ByteCode;
import com.gomez_juan_lopez_javier.commands.Command;
import com.gomez_juan_lopez_javier.exceptions.ArrayException;
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
	private ByteCodeProgram program;
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
	private ByteCodeProgram bytecodeProgram;
	
	/**
	 * Constructor por defecto de {@link Engine}.
	 */
	public Engine (){
		this.end = false;
	}
	
	/**
	 * Inicia el motor {@link Engine} y lee los comandos introducidos y los parsea convenientemente. Si el comando
	 * introducido no es correcto se mostrara un error.
	 * @throws ArrayException 
	 * @throws LexicalAnalysisException 
	 */
	public void start () {
		this.program = new ByteCodeProgram();
		this.cpu = new CPU();
		sc = new java.util.Scanner(System.in); 
		
		while(!this.end){
			System.out.print("> ");
			
			String cadenaComando = sc.nextLine();
			
			comando = CommandParser.parse(cadenaComando);
			
			if (comando != null) {
				try {
					comando.execute(this);
				} catch (LexicalAnalysisException | ArrayException e) {
					System.out.println("Ha ocurrido un error.");
					//e.printStackTrace();
				}
			}
			else {
				
				System.out.println(cadenaComando + ": No se encontro el comando");
				System.out.println();
			}
		}
		sc.close();
	}
	
	/**
	 * Metodo para ejecutar Bytecode.
	 */
	public void ejecutarAddByteCode() {
		System.out.println("Comienza la ejecucion de BYTECODE");
		System.getProperty("line.separator");
		System.out.println("Introduce el bytecode. Una instruccion por linea:");
		System.getProperty("line.separator");
		
		readByteCodeProgram();
		
		System.out.println("Programa almacenado:");
		System.getProperty("line.separator");
		System.out.println(this.program.toString());
	}
	
	/**
	 * Metodo para mostrar ejecutar y mostrar HELP.
	 * 
	 * @return verdadero si ha mostrado la ayuda.
	 */
	public boolean ejecutarHelp() {
		CommandParser.showHelp();
		return true;
	}
	
	/**
	 * Metodo para ejecutar el comando RUN.
	 */
	public void ejecutarRun() {
		this.cpu = new CPU();
		System.out.println("Comienza la ejecucion de RUN");
		this.cpu.programToCPU(program);
		if(cpu.run()){
			System.out.println("El estado de la maquina tras ejecutar el programa es:");
			System.out.println(this.cpu.memoryToString());
			System.out.println(this.cpu.stackToString()+ "\n");
		}
		else{
			System.out.println("ERROR: Ejecucion incorrecta del programa.");
		}
		
		System.out.println("Programa almacenado: ");
		System.out.println(this.program.toString());
	}
	
	/**
	 * Metodo para ejecutar el comando RESET.
	 */
	public void ejecutarReset() {
		System.out.println("Comienza la ejecucion de RESET");
		this.program = new ByteCodeProgram();
	}
	
	/**
	 * Metodo para ejecutar el comando REPLACE.
	 * 
	 * @param lineToReplace Posicion en el programa de la instruccion {@link ByteCode} a reemplazar.
	 */
	public void ejecutarReplace(int lineToReplace) {
		System.out.println("Comienza la ejecucion de REPLACE");
		if(lineToReplace > program.getProgramSize() || program.readInstructionAt(lineToReplace)== null){
			System.out.println("Comando REPLACE ha fallado. La línea de instruccion indicada a substituir no es valido, o no existe ningún programa en memoria.");
		}
		else {
			System.out.println("Antigua instrucción en la línea " + lineToReplace + ": " + program.readInstructionAt(lineToReplace).toString());
			System.out.print("Nueva instruccion? ");
			String newInstruction = sc.nextLine();
			ByteCode instruction = ByteCodeParser.parse(newInstruction);
			if(!program.writeInstructionAt(instruction, lineToReplace)){
				System.out.println("Comando REPLACE ha fallado. La nueva instruccion no es valida.");
			}
		}
		System.out.println("Programa almacenado: ");
		System.out.println(this.program.toString());
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
	 */
	public boolean readByteCodeProgram() {
		boolean end = false;
		
		while(!end){
			String cadenaBytecode = sc.nextLine();
			
			if (!cadenaBytecode.matches("end")) {
				instruccion = ByteCodeParser.parse(cadenaBytecode);
				
				if (instruccion != null){
					program.writeNextInstruction(instruccion);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void generateByteCode () throws ArrayException {
		// TODO Auto-generated method stub
		
	}

	private void LexicalAnalysis() throws LexicalAnalysisException {
		pProgram = new ParsedProgram();
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
					throw new ArrayException();	
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
