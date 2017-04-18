package misc;

import java.util.ArrayList;

import model.Carro;
import model.Conta;
import model.Pessoa;

public class MockupData {

	public static ArrayList<Conta> conta;
	public static ArrayList<Carro> carrosStand;
	public static ArrayList<Pessoa> clientes;
	public static boolean existe;
	
	public MockupData(){
		
		existe = false;
		conta = new ArrayList<>();
		carrosStand = new ArrayList<>();
		clientes = new ArrayList<>();
	}
}
