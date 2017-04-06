package application;

import java.util.Scanner;

import misc.MockupData;
import view.Interface;

public class ATM {

	static Scanner n = new Scanner(System.in);
	static Interface i = new Interface();
	static MockupData bd = new MockupData();
	
	public ATM(){
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean verf=true, verfF=true, verfC=true;
		
		do{
			i.menuP();
			int opc = n.nextInt();
			switch(opc){
			case 1:
				do{
					i.menuF();
					int opcF = n.nextInt();
					switch(opcF){
					case 1:
						i.regConta();
						break;
					case 2:
						i.listContas();
						break;
					case 3: 
						verfF=false;
					default:
						System.out.println("OPCAO INVALIDA");
					}
				}while(verfF);
				break;
			case 2:
				do{
					i.menuC();
					int opcC = n.nextInt();
					switch(opcC){
					case 1:
						i.depositarValor();
						break;
					case 2:
						i.levantarValor();
						break;
					case 3:
						i.transferirValor();
						break;
					case 4:
						i.verSaldo();
						break;
					case 5:
						verfC=false;
						break;
					default:
						System.out.println("OPCAO INVALIDA");
					}
				}while(verfC);
				
				break;
			case 3:
				verf=false;
				break;
			default: 
				System.out.println("OPCAO INVALIDDA");
			}
		}while(verf);
	}
		
	
}
	
	
