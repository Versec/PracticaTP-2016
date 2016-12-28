package com.GomezJuan.LopezJavier;

/**
 * Clase Engine:
 * 
 * Motor encargado de controlar el programa.
 * 
 * @author Juan Gomez 
 * @author Javier Lopez
 * @version 1.0
 */

public class Engine {
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
	 * Constructor por defecto de {@link Engine}.
	 */
	public Engine (){
		this.end = false;
	}
	
	/**
	 * Inicia el motor {@link Engine} y lee los comandos introducidos y los parsea convenientemente. Si el comando
	 * introducido no es correcto se mostrara un error.
	 */
	public void start (){
		this.program = new ByteCodeProgram();
		sc = new java.util.Scanner(System.in); 
		
		while(!this.end){
			System.out.print("> ");
			
			String cadenaComando = sc.nextLine();
			
			
			Command comando = CommandParser.parse(cadenaComando);
			
			if (comando != null) {
				boolean exec = comando.execute(this);
				
				if (!exec) {
					System.out.println("Ha ocurido un error.");
				}
			}
			else {
				System.out.println(cadenaComando + ": No se encontro el comando");
			}
		}
		sc.close();
	}
	
	/**
	 * Metodo para mostrar ejecutar y mostrar HELP.
	 */
	public void ejecutarHelp(){
		System.out.println("Comienza la ejecucion de HELP \n \n"
				+ "HELP: Muestra esta ayuda. \n"
				+ "QUIT: Cierra la aplicacion. \n"
				+ "RUN: Ejecuta el programa. \n"
				+ "NEWINST BYTECODE: Introduce una nueva instruccion al programa. \n"
				+ "RESET: Vacia el programa actual. \n"
				+ "REPLACE N: Reemplaza la instruccion N por la solicitada al usuario. \n");
	}
	
	/**
	 * Metodo para ejecutar el comando NEWINST.
	 * 
	 * @param instruction instruccion {@link ByteCode} a ejecutar.
	 */
	public void ejecutarNewInst(ByteCode instruction){
		if (instruction != null) {
			System.out.println("Comienza la ejecucion de NEWINST " + instruction.toString());
			program.writeNextInstruction(instruction);
		}
		else {
			System.out.println("Comienza la ejecucion de NEWINST");
			System.out.println("ERROR: Ejecucion incorrecta del comando");
		}
		System.out.println("Programa almacenado: ");
		System.out.println(this.program.toString());
	}
	
	/**
	 * M�todo para ejecutar el comando RUN.
	 */
	public void ejecutarRun() {
		System.out.println("Comienza la ejecucion de RUN");
		this.cpu = new CPU();
		for (int i = 0; i < this.program.getProgramSize(); i++) {
			if(cpu.isRunning()){
				if(this.cpu.execute(this.program.readInstructionAt(i))){
					System.out.println("El estado de la maquina tras ejecutar " + 
							this.program.readInstructionAt(i).toString());
					System.out.println(this.cpu.getMemoryState());
					System.out.println(this.cpu.getStackState()+ "\n");
				}
				else{
					System.out.println("ERROR: Ejecucion incorrecta del comando.");
				}
			}
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
	 * @param instructionToReplace Posicion en el programa de la instruccion {@link ByteCode} a reemplazar.
	 */
	public void ejecutarReplace(int instructionToReplace) {
		System.out.println("Comienza la ejecucion de REPLACE");
		if(instructionToReplace > program.getProgramSize()){
			System.out.println("Comando REPLACE ha fallado. el numero de instruccion indicado a substituir no es valido.");
		}
		else {
			System.out.print("Nueva instruccion? ");
			String newInstruction = sc.nextLine();
			ByteCode instruction = ByteCodeParser.parse(newInstruction);
			if(!program.writeInstructionAt(instruction, instructionToReplace)){
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
}
