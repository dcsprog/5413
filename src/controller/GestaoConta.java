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
		MockupData.conta.add(new Conta(p));
		
	}
	
	
	public void listarContas(ArrayList<Conta> co){
		
		for(Conta c : co){
			System.out.println(c.getPessoa().getNome());
		}
	}

}
