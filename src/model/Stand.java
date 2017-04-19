package model;

public class Stand {

	public Stand(){
		
	}
	
	public Stand(int numeroNIF,String nomeStand, String morada, String telefone, Conta contaBancaria) {
		super();
		this.numeroNIF = numeroNIF;
		this.nomeStand = nomeStand;
		this.morada = morada;
		this.telefone = telefone;
		this.contaBancaria = contaBancaria;
	}

	private int numeroNIF;
	private String nomeStand;
	private String morada;
	private String telefone;
	private Conta contaBancaria;
	
	public String getNomeStand() {
		return nomeStand;
	}
	public void setNomeStand(String nomeStand) {
		this.nomeStand = nomeStand;
	}
	public String getMorada() {
		return morada;
	}
	public void setMorada(String morada) {
		this.morada = morada;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Conta getContaBancaria() {
		return contaBancaria;
	}
	
	public void setContaBancaria(Conta contaBancaria) {
		this.contaBancaria = contaBancaria;
	}

	public int getNumeroNIF() {
		return numeroNIF;
	}

	public void setNumeroNIF(int numeroNIF) {
		this.numeroNIF = numeroNIF;
	}



	
	
}
