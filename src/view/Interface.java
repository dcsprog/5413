package view;

import java.util.Scanner;

import controller.GestaoConta;
import misc.MockupData;
import model.Conta;

public class Interface {
	
	static Scanner n = new Scanner(System.in);
	static GestaoConta g = new GestaoConta();
	static MockupData bd = new MockupData();;
	
	public Interface(){
	
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
		System.out.println("\t         4 - VER SALDO");
		System.out.println("\t         5 - SAIR");
	}
	
	
	public void regConta(){
		System.out.println("INTRODUZA O NOME DO TITULAR: ");
		String nome = n.nextLine();
		g.addConta(nome);	
	}
	
	public void listContas(){
		g.listarContas();
	}
	
	public void depositarValor(){
		System.out.println("INTRODUZA O NUMERO DE CONTA: ");
		int num = n.nextInt();
		System.out.println("INTRODUZA O VALOR: ");
		float valor = n.nextFloat();
		g.depositar(num, valor);
	}
	
	public void levantarValor(){
		System.out.println("INTRODUZA O NUMERO DE CONTA: ");
		int num = n.nextInt();
		System.out.println("INTRODUZA O VALOR: ");
		float valor = n.nextFloat();
		g.levantar(num, valor);
	}
	
	public void transferirValor(){
		System.out.println("INTRODUZA O NUMERO DA SUA CONTA: ");
		int numR = n.nextInt();
		System.out.println("INTRODUZA O NUMERO DA CONTA DE DESTINO: ");
		int numD = n.nextInt();
		g.transferir(numR, numD);
	}
	
	public void verSaldo(){
		System.out.println("INTRODUZA O NUMERO DA CONTA: ");
		int num = n.nextInt();
		float c = g.verificarSaldo(num);
		System.out.println("SALDO: "+c);
	}
}
