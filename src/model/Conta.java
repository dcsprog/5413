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
	private double saldo;
	private Pessoa pessoa;
	
	public int getNumeroConta() {
		return numeroConta;
	}
	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	
	
	
	
}
