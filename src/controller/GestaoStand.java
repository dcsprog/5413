package controller;

import misc.MockupData;
import model.Carro;
import model.Conta;
import model.Pessoa;
import model.Stand;

public class GestaoStand {

	static MockupData bd ;
	
	public GestaoStand(){
		bd = new MockupData();
	}
	
	public void addStand(int nif,String nomeStand, String morada, String telefone){
		final String pass ="1234"; 
		Pessoa p = new Pessoa(nomeStand);
		Conta c;
		bd.conta.add(c = new Conta(bd.conta.size(),50000,p,pass));
		bd.reg.setNumeroNIF(nif);
		bd.reg.setNomeStand(nomeStand);
		bd.reg.setMorada(morada);
		bd.reg.setTelefone(telefone);
		bd.reg.setContaBancaria(c);
	}
	
	public Stand dadosStand(Stand s){
		
		/*
		System.out.println("NUMERO DO NIF: "+s.getNumeroNIF());
		System.out.println("NOME DO STAND: "+s.getNomeStand());
		System.out.println("MORADA DO STAND: "+s.getMorada());
		System.out.println("TELEFONE DO STAND: "+s.getTelefone());
		System.out.println("NUMERO DA CONTA STAND: "+s.getContaBancaria().getNumeroConta());
		System.out.println("SALDO DA CONTA STAND: "+s.getContaBancaria().getSaldo());*/
		
		Stand novo;
		novo = new Stand(bd.reg.getNumeroNIF(),bd.reg.getNomeStand(),bd.reg.getMorada(),bd.reg.getTelefone(),bd.reg.getContaBancaria());
		
		return novo;
	}
	
	public void addCliente(String nome){
		
		Pessoa p = new Pessoa(nome);
		bd.clientes.add(p);
	
	}
	
	public void comprarCarroDoCli(String marca, String modelo, String placa, double preco, Stand s){

		if(preco<=s.getContaBancaria().getSaldo()){
			Carro c = new Carro(bd.carrosStand.size(), marca, modelo, placa, preco);
			bd.carrosStand.add(c);
			String p= s.getContaBancaria().getPessoa().getNome();
			Pessoa ps = new Pessoa(p);
			Conta c1 = new Conta(s.getContaBancaria().getNumeroConta(),s.getContaBancaria().getSaldo()-preco,ps,s.getContaBancaria().getSenha());
			//s.setContaBancaria(s.getContaBancaria().getSaldo()-preco);
			bd.reg.setContaBancaria(c1);
		}
	}
	
	public void venderCarroAoCli(String marca, String modelo, String placa, double preco, Stand s,int numConta){

		if(preco<=bd.conta.get(numConta).getSaldo()){
			Carro c = new Carro(bd.carrosStand.size(), marca, modelo, placa, preco);
			bd.carrosStand.remove(c);
			//s.setContaBancaria(s.getContaBancaria().getSaldo()+preco);
			String p= s.getContaBancaria().getPessoa().getNome();
			Pessoa ps = new Pessoa(p);
			Conta c1 = new Conta(s.getContaBancaria().getNumeroConta(),s.getContaBancaria().getSaldo()+preco,ps,s.getContaBancaria().getSenha());
		}
	}
}
