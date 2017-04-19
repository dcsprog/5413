package model;

public class Conta {

	

	public Conta(){
		
	}
//
	public Conta(int numeroConta,double saldo,Pessoa pessoa,String senha) {
		super();
		this.numeroConta = numeroConta;
		this.saldo = saldo;
		this.pessoa = pessoa;
		this.setSenha(senha);
	}

	private int numeroConta;
	private double saldo;
	private Pessoa pessoa;
	private String senha;
	
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
	
	
}
