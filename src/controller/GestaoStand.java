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
	
	public void add(int nif,String nomeStand, String morada, String telefone, Conta contaBancaria){
		Stand s = new Stand(nif,nomeStand,morada,telefone,contaBancaria);
	}
	
	public void dadosStand(Stand s){
		
		System.out.println("NUMERO DO NIF: "+s.getNumeroNIF());
		System.out.println("NOME DO STAND: "+s.getNomeStand());
		System.out.println("MORADA DO STAND: "+s.getMorada());
		System.out.println("TELEFONE DO STAND: "+s.getTelefone());
		System.out.println("NUMERO DA CONTA STAND: "+s.getContaBancaria().getNumeroConta());
		System.out.println("SALDO DA CONTA STAND: "+s.getContaBancaria().getSaldo());
		
	}
	
	public void addCliente(String nome){
		
		Pessoa p = new Pessoa(nome);
		bd.clientes.add(p);
	
	}
	
	public void comprarCarroDoCli(String marca, String modelo, String placa, double preco, Stand s){

		if(preco<=s.getContaBancaria().getSaldo()){
			Carro c = new Carro(bd.carrosStand.size(), marca, modelo, placa, preco);
			bd.carrosStand.add(c);
			s.setContaBancaria(s.getContaBancaria().getSaldo()-preco);
		}
	}
	
	public void venderCarroAoCli(String marca, String modelo, String placa, double preco, Stand s,int numConta){

		if(preco<=bd.conta.get(numConta).getSaldo()){
			Carro c = new Carro(bd.carrosStand.size(), marca, modelo, placa, preco);
			bd.carrosStand.remove(c);
			s.setContaBancaria(s.getContaBancaria().getSaldo()+preco);
		}
	}
}
