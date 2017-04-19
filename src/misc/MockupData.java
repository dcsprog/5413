package misc;

import java.util.ArrayList;

import model.Carro;
import model.Conta;
import model.Pessoa;
import model.Stand;

public class MockupData {

	public static ArrayList<Conta> conta;
	public static ArrayList<Carro> carrosStand;
	public static ArrayList<Pessoa> clientes;
	public static boolean existe;
	public static Stand reg;
	
	public MockupData(){
		
		reg = new Stand();
		existe = false;
		conta = new ArrayList<>();
		carrosStand = new ArrayList<>();
		clientes = new ArrayList<>();
	}
}
