package view;

import java.util.Scanner;

import controller.GestaoConta;
import mis.MockupData;

public class Interface {
	
	Scanner n = new Scanner(System.in);
	GestaoConta g = new GestaoConta();
	MockupData bd;
	
	public Interface(){
		bd = new MockupData();
	}
	
	public void menuP(){
		
		System.out.println("\t---------------------------------");
		System.out.println("\t        BEM VINDO AO BANCO");
		System.out.println("\t         1 - MENU FUNCIONARIO");
		System.out.println("\t         2 - MENU CLIENTE");
		System.out.println("\t         3 - SAIR");
		
	}
	
	public void menuF(){
		
		System.out.println("\t---------------------------------");
		System.out.println("\t        BEM VINDO AO BANCO");
		System.out.println("\t         1 - CRIAR CONTAS");
		System.out.println("\t         2 - LISTAR CONTAS");
		System.out.println("\t         3 - SAIR");
		
	}
	
	public void menuC(){
		
		System.out.println("\t---------------------------------");
		System.out.println("\t        BEM VINDO AO BANCO       ");
		System.out.println("\t         1 - DEPOSITAR         ");
		System.out.println("\t         2 - LEVANTAR   ");
		System.out.println("\t         3 - TRANSFERIR");
		System.out.println("\t         4 - SAIR");
	}
	
	
	public void regConta(){
		System.out.println("INTRODUZA O NOME DO TITULAR: ");
		String nome = n.nextLine();
		g.addConta(nome);	
	}
	
	public void listContas(){
		g.listarContas();
	}
	
}
