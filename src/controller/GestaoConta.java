package controller;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import misc.MockupData;
import model.Conta;
import model.Pessoa;

public class GestaoConta {
	
	static Scanner n = new Scanner(System.in);
	static MockupData bd;
	
	public GestaoConta(){
		bd = new MockupData();
	}
	
	public void addConta(String nome, String senha){
		
		Pessoa p = new Pessoa(nome);
		bd.conta.add(new Conta(bd.conta.size(),0,p,senha));
		
	}
	
	
	public void listarContas(){
		
		for(int i=0;i < bd.conta.size();i++){
			System.out.println("\n");
			System.out.println("NUMERO DA CONTA: "+bd.conta.get(i).getNumeroConta());
			System.out.println("NOME DO TITULAR: "+bd.conta.get(i).getPessoa().getNome());
			System.out.println("SALDO: € "+bd.conta.get(i).getSaldo());
			System.out.println("\n");
		}
	}
	
	public void depositar(int numConta, double valor){
		//numConta-=1;
		if(bd.conta.size()!=0){
			if(numConta==bd.conta.get(numConta).getNumeroConta()){
				bd.conta.get(numConta).setSaldo(bd.conta.get(numConta).getSaldo()+valor);
			}else{
				//System.out.println("\tNUMEO DE CONTA É INVALIDO\n");
				JOptionPane.showMessageDialog(null, "NUMEO DE CONTA É INVALIDO!",null,JOptionPane.INFORMATION_MESSAGE);
			}
		}else{
			//System.out.println("\tNAO EXISTEM CONTAS REGISTADAS\n");
			JOptionPane.showMessageDialog(null, "NAO EXISTEM CONTAS REGISTADAS",null,JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	
	public void levantar(int num, double valor){
	//	num-=1;
		if(bd.conta.size()!=0){
			if(num==bd.conta.get(num).getNumeroConta()){
				if(valor<bd.conta.get(num).getSaldo()){
					bd.conta.get(num).setSaldo(bd.conta.get(num).getSaldo()-valor);
				}else{
					//System.out.println("\nSALDO INSUFICIENTE\n");
					JOptionPane.showMessageDialog(null, "SALDO INSUFICIENTE!",null,JOptionPane.INFORMATION_MESSAGE);
				}
				
			}else{
				//System.out.println("\nNUMEO DE CONTA É INVALIDO\n");
				JOptionPane.showMessageDialog(null, "NUMEO DE CONTA É INVALIDO!",null,JOptionPane.INFORMATION_MESSAGE);
			}
		}else{
			//System.out.println("\nNAO EXISTEM CONTAS REGISTADAS\n");
			JOptionPane.showMessageDialog(null, "NAO EXISTEM CONTAS REGISTADAS",null,JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public void transferir(int numContaR, int numContaD){
		//numContaR-=1;
		//numContaD-=1;
		if(bd.conta.size()!=0){
			if(numContaR==bd.conta.get(numContaR).getNumeroConta()){
				System.out.println("INTRODUZA O VALOR A TRANSFEREIR: ");
				float v=n.nextFloat();
				if(v<=bd.conta.get(numContaR).getSaldo()){
					bd.conta.get(numContaR).setSaldo(bd.conta.get(numContaR).getSaldo()-v);
					if(numContaD==bd.conta.get(numContaD).getNumeroConta()){
						bd.conta.get(numContaD).setSaldo(bd.conta.get(numContaD).getSaldo()+v);
					}else{
						//System.out.println("NUMERO DA CONTA DO DESTINO E INVALIDO");
						JOptionPane.showMessageDialog(null, "NUMEO DE CONTA DO DESTINO É INVALIDO!",null,JOptionPane.INFORMATION_MESSAGE);
					}
				}else{
					//System.out.println("SALDO INSUFICIENTE");
					JOptionPane.showMessageDialog(null, "SALDO INSUFICIENTE!",null,JOptionPane.INFORMATION_MESSAGE);
				}
			}else{
				//System.out.println("\nNUMERO DE CONTA É INVALIDO\n");
				JOptionPane.showMessageDialog(null, "NUMEO DE CONTA É INVALIDO!",null,JOptionPane.INFORMATION_MESSAGE);
			}		
		}else{
			//System.out.println("\nNAO EXISTEM CONTAS REGISTADAS\n");
			JOptionPane.showMessageDialog(null, "NAO EXISTEM CONTAS REGISTADAS",null,JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	
	public float verificarSaldo(int num){
		//num-=1;
		float cs=0;
		for(int i=0; i<bd.conta.size();i++){
			if(num==bd.conta.get(i).getNumeroConta()){
				cs+=bd.conta.get(i).getSaldo();
			}
		}
		return cs;
	}

}
