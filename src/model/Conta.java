package model;

public class Conta {

	public Conta(){
		
	}
	
	
	
	public Conta(Pessoa pessoa) {
		super();
		this.numeroConta = getNumeroConta()+1;
		this.saldo = 0;
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
