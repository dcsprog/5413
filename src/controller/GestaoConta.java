package controller;

import java.util.ArrayList;
import java.util.Scanner;

import misc.MockupData;
import model.Conta;
import model.Pessoa;

public class GestaoConta {
	
	static Scanner n = new Scanner(System.in);
	static MockupData bd;
	
	public GestaoConta(){
		bd = new MockupData();
	}
	
	public void addConta(String nome){
		
		Pessoa p = new Pessoa(nome);
		bd.conta.add(new Conta(bd.conta.size(),0,p));
		
	}
	
	
	public void listarContas(){
		
		for(int i=0;i < bd.conta.size();i++){
			System.out.println("\n\n");
			System.out.println("NUMERO DA CONTA: "+bd.conta.get(i).getNumeroConta());
			System.out.println("NOME DO TITULAR: "+bd.conta.get(i).getPessoa().getNome());
			System.out.println("SALDO: "+bd.conta.get(i).getSaldo());
			System.out.println("\n\n");
		}
	}
	
	public void depositar(int numConta, float valor){

		if(bd.conta.size()!=0){
			if(numConta==bd.conta.get(numConta).getNumeroConta()){
				bd.conta.get(numConta).setSaldo(bd.conta.get(numConta).getSaldo()+valor);
			}else{
				System.out.println("\tNUMEO DE CONTA É INVALIDO\n");
			}
		}else{
			System.out.println("\tNAO EXISTEM CONTAS REGISTADAS\n");
		}
		
	}
	
	public void levantar(int num, float valor){
		
		if(bd.conta.size()!=0){
			if(num==bd.conta.get(num).getNumeroConta()){
				if(valor<bd.conta.get(num).getSaldo()){
					bd.conta.get(num).setSaldo(bd.conta.get(num).getSaldo()-valor);
				}else{
					System.out.println("\nSALDO INSUFICIENTE\n");
				}
				
			}else{
				System.out.println("\nNUMEO DE CONTA É INVALIDO\n");
			}
		}else{
			System.out.println("\nNAO EXISTEM CONTAS REGISTADAS\n");
		}
	}
	
	public void transferir(int numContaR, int numContaD){

		if(bd.conta.size()!=0){
			if(numContaR==bd.conta.get(numContaR).getNumeroConta()){
				System.out.println("INTRODUZA O VALOR A TRANSFEREIR: ");
				float v=n.nextFloat();
				if(v<=bd.conta.get(numContaR).getSaldo()){
					bd.conta.get(numContaR).setSaldo(bd.conta.get(numContaR).getSaldo()-v);
					if(numContaD==bd.conta.get(numContaD).getNumeroConta()){
						bd.conta.get(numContaD).setSaldo(bd.conta.get(numContaD).getSaldo()+v);
					}else{
						System.out.println("NUMERO DA CONTA DO DESTINO E INVALIDO");
					}
				}else{
					System.out.println("SALDO INSUFICIENTE");
				}
			}else{
				System.out.println("\nNUMERO DE CONTA É INVALIDO\n");
			}		
		}else{
			System.out.println("\nNAO EXISTEM CONTAS REGISTADAS\n");
		}
	}
	
	
	public float verificarSaldo(int num){

		float cs=0;
		for(int i=0; i<bd.conta.size();i++){
			if(num==bd.conta.get(i).getNumeroConta()){
				cs+=bd.conta.get(i).getSaldo();
			}
		}
		return cs;
	}

}
