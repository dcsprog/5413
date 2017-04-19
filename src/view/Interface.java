package view;

import java.util.Scanner;

import controller.GestaoConta;
import misc.MockupData;
import model.Conta;

public class Interface {
	
	static Scanner n = new Scanner(System.in);
	static GestaoConta g = new GestaoConta();
	static MockupData bd;
	
	public Interface(){
		
		bd = new MockupData();
	}
	//
	public void menuP(){
		
		System.out.println("\t---------------------------------");
		System.out.println("\t        BEM VINDO AO BANCO");
		System.out.println("\t         1 - MENU FUNCIONARIO");
		System.out.println("\t         2 - MENU CLIENTE");
		System.out.println("\t         3 - SAIR");
		System.out.println("\t---------------------------------");
		
	}
	
	public void menuF(){
		
		System.out.println("\t---------------------------------");
		System.out.println("\t        BEM VINDO AO BANCO");
		System.out.println("\t         1 - CRIAR CONTAS");
		System.out.println("\t         2 - LISTAR CONTAS");
		System.out.println("\t         3 - SAIR");
		System.out.println("\t---------------------------------");
		
	}
	
	public void menuC(){
		
		System.out.println("\t---------------------------------");
		System.out.println("\t        BEM VINDO AO BANCO       ");
		System.out.println("\t         1 - DEPOSITAR         ");
		System.out.println("\t         2 - LEVANTAR   ");
		System.out.println("\t         3 - TRANSFERIR");
		System.out.println("\t         4 - VER SALDO");
		System.out.println("\t         5 - SAIR");
		System.out.println("\t---------------------------------");
		
	}
	
	
	public void regConta(){
		String senha, senhaRep;
		boolean verf=true;
		System.out.println("INTRODUZA O NOME DO TITULAR: ");
		String nome = n.nextLine();
		do{
			System.out.println("INTRODUZA A SENHA: ");
			senha = n.nextLine();
			System.out.println("INTRODUZA A SENHA NOVAMENTE: ");
			senhaRep = n.nextLine();
			if(senha.equals(senhaRep)){
				verf=false;
			}else{
				System.out.println("AS SENHAS INSERIDAS NAO CORRESPONDEM");
			}
		}while(verf);
		
		g.addConta(nome,senha);	
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
		double valor = n.nextFloat();
		g.levantar(num, valor);
		
	}
	
	public void transferirValor(){
		
		System.out.println("INTRODUZA O NUMERO DA SUA CONTA: ");
		int numR = n.nextInt();
		System.out.println("INTRODUZA O NUMERO DA CONTA DE DESTINO: ");
		int numD = n.nextInt();
		double v = 20;
		g.transferir(numR, numD,v);
		
	}
	
	public void verSaldo(){
		
		System.out.println("INTRODUZA O NUMERO DA CONTA: ");
		int num = n.nextInt();
		double c = g.verificarSaldo(num);
		System.out.println("SALDO: "+c);
	}
	
}
