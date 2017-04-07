package model;

public class Carro {

	public Carro(){
		
	}
	
	public Carro(int idCar, String marca, String modelo, String placa, double preco) {
		super();
		this.idCar = idCar;
		this.marca = marca;
		this.modelo = modelo;
		this.placa = placa;
		this.preco = preco;
	}

	private int idCar;
	private String marca;
	private String modelo;
	private String placa;
	private double preco;
	
	
	public int getIdCar() {
		return idCar;
	}

	public void setIdCar(int idCar) {
		this.idCar = idCar;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	
	
	
	
	
}
