//
//  Main.java
//  BMOCompiler
//
//  Created by Breno Medeiros on 12/09/20.
//  Copyright © 2020 ProgramasBMO. All rights reserved.
//



public class Main {

	
	// Terminais = {a,b,c,d}
	// Não-terminais = {X,Y}
	// Produções = { 
	// 		X --> a X 
	//		X --> b Y 
	//		Y --> Y c
	// 		Y --> d 
	// }
	// Não-terminal Inicial = X
	public static void geradorLinguagemExemplo(String s,int limite) { 
		if (limite==0) {
			return;
		}
		if (s.contains("X")) {
			geradorLinguagemExemplo(s.replace("X","bY"),limite-1);
			geradorLinguagemExemplo(s.replace("X","aX"),limite-1); 
		} else if (s.contains("Y")) {
			geradorLinguagemExemplo(s.replace("Y","Yc"),limite-1);
			geradorLinguagemExemplo(s.replace("Y","d"), limite-1); 
		} else {
			System.out.println("Palavra : " + s);
		}
		 
	}
	

	// Terminais = { n, +, -, *, /, (, ) }
	// Não-terminais = {Expr}
	// Produções = { 
	// 		Expr --> n
	// 		Expr --> Expr + Expr
	// 		Expr --> Expr - Expr
	// 		Expr --> Expr * Expr
	// 		Expr --> Expr / Expr
	// 		Expr --> ( Expr )
	// }
	// Não-terminal Inicial = Expr
	public static void geradorLinguagemExpressoes(String s,int limite) { 
		if (limite==0) {
			return;
		}
		if (s.contains("Expr")) {
			geradorLinguagemExpressoes(s.replace("Expr","n"),limite-1);
			geradorLinguagemExpressoes(s.replace("Expr","Expr+Expr"),limite-1); 
			geradorLinguagemExpressoes(s.replace("Expr","Expr-Expr"),limite-1); 
			geradorLinguagemExpressoes(s.replace("Expr","Expr*Expr"),limite-1); 
			geradorLinguagemExpressoes(s.replace("Expr","Expr/Expr"),limite-1); 
			geradorLinguagemExpressoes(s.replace("Expr","(Expr)"),limite-1); 
		} else {
			System.out.println("Palavra : " + s);
		}
		 
	}
	
	
	// Terminais = { if then else while do Expr id = ; { } }
	// Não-terminais = {COM}
	// Produções = {
	// 		COM --> if Expr then COM else COM
	// 		COM --> while Expr do COM
	// 		COM --> { COM COM }
	// 		COM --> id = Expr ;
	// }
	// Não-terminal Inicial = COM
	public static void geradorLinguagemComandos(String s,int limite) { 
		if (limite==0) {
			return;
		}
		if (s.contains("COM")) {
			geradorLinguagemComandos(s.replace("COM","while Expr do COM"),limite-1); 
			geradorLinguagemComandos(s.replace("COM","if Expr then { COM } else { COM }"),limite-1); 
			geradorLinguagemComandos(s.replace("COM","{ COM COM }"),limite-1); 
			geradorLinguagemComandos(s.replace("COM","id = Expr ;"),limite-1);
		} else {
			System.out.println("Palavra : " + s);
		}
		 
	}
	
	
	public static void geradorLinguagemComandosEExpressoes(String s,int limite) { 
		
		if (limite==0) {
			return;
		}
		if (s.contains("COM")) {
			geradorLinguagemComandosEExpressoes(s.replace("COM","while Expr do COM"),limite-1); 
			geradorLinguagemComandosEExpressoes(s.replace("COM","if Expr then { COM } else { COM }"),limite-1); 
			geradorLinguagemComandosEExpressoes(s.replace("COM","{ COM COM }"),limite-1); 
			geradorLinguagemComandosEExpressoes(s.replace("COM","id = Expr ;"),limite-1);
		} else {
			geradorLinguagemExpressoes(s,3);
		}
		 
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(" ------------------------------------ Exemplo ------------------------------------- ");
		geradorLinguagemExemplo("X",10);
		
		System.out.println(" ----------------------------------- Expressoes ----------------------------------- ");
		geradorLinguagemExpressoes("Expr",5);
		
		System.out.println(" ------------------------------------ Comandos ------------------------------------ ");
		geradorLinguagemComandos("COM",5);

		
		System.out.println(" ----------------------------- Comandos e Expressoes ------------------------------ ");
		geradorLinguagemComandosEExpressoes("COM",4);
	}

	
	
	
	

	
	
}
