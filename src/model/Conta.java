package model;

public class Conta {

	public Conta(){
		
	}
	
	
	
	public Conta(int numeroConta,float saldo,Pessoa pessoa) {
		super();
		this.numeroConta = numeroConta;
		this.saldo = saldo;
		this.pessoa = pessoa;
	}



	private int numeroConta;
	private float saldo;
	private Pessoa pessoa;
	
	public int getNumeroConta() {
		return numeroConta;
	}
	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	
	
	
	
}
