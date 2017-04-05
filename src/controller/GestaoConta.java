package controller;

import java.util.ArrayList;
import java.util.Scanner;

import mis.MockupData;
import model.Conta;
import model.Pessoa;

public class GestaoConta {
	
	Scanner n = new Scanner(System.in);
	MockupData bd = new MockupData();
	
	
	public void addConta(String nome){
		
		Pessoa p = new Pessoa(nome);
		bd.conta.add(new Conta(p));
		
	}
	
	
	public void listarContas(){
		
		for(int i=0;i < bd.conta.size();i++){
			System.out.println("\n\n");
			System.out.println("NUMERO DA CONTA: "+bd.conta.get(i).getNumeroConta());
			System.out.println("NOME DO TITULAR: "+bd.conta.get(i).getPessoa());
			System.out.println("SALDO: "+bd.conta.get(i).getSaldo());
			System.out.println("\n\n");
		}
	}
	
	public void depositar(int numConta, float valor){
		if(bd.conta.size()!=0){
			if(numConta==bd.conta.get(numConta-1).getNumeroConta()){
				bd.conta.get(numConta-1).setSaldo(valor);
			}else{
				System.out.println("\nNUMEO DE CONTA É INVALIDO\n");
			}
		}else{
			System.out.println("\nNAO EXISTEM CONTAS REGISTADAS\n");
		}
	}
	
	public void levantar(int num, float valor){
		if(bd.conta.size()!=0){
			if(num==bd.conta.get(num-1).getNumeroConta()){
				if(valor<bd.conta.get(num-1).getSaldo()){
					bd.conta.get(num-1).setSaldo(bd.conta.get(num-1).getSaldo()-valor);
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
			if(numContaR==bd.conta.get(numContaR-1).getNumeroConta()){
				System.out.println("INTRODUZA O VALOR A TRANSFEREIR: ");
				float v=n.nextFloat();
				if(v<=bd.conta.get(numContaR-1).getSaldo()){
					if(numContaD==bd.conta.get(numContaD-1).getNumeroConta()){
						bd.conta.get(numContaD-1).setSaldo(bd.conta.get(numContaD-1).getSaldo()+v);
					}else{
						System.out.println("NUMERO DA CONTA DO DESTINO E INVALIDO");
					}
				}else{
					System.out.println("SALDO INSUFICIENTE");
				}
			}else{
				System.out.println("\nNUMEO DE CONTA É INVALIDO\n");
			}		
		}else{
			System.out.println("\nNAO EXISTEM CONTAS REGISTADAS\n");
		}
	}

}
