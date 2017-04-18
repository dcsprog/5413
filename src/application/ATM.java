package application;




import java.util.Scanner;

import misc.MockupData;
import view.Interface;
import view.InterfaceSwing;


public class ATM {

	static Scanner n = new Scanner(System.in);
	static Interface i = new Interface();
	
	static InterfaceSwing interf = new InterfaceSwing();
	static MockupData bd;
	
	public ATM(){
		bd = new MockupData();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		interf.menuInicial();
		
	}
		
   
	




	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
	
	
boolean verf=true, verfF=true, verfC=true;

do{
	//interf.menuInicial();
	i.menuP();
	int opc = n.nextInt();
	switch(opc){
	case 1:
		do{
			/*EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						MenuFStannd window = new MenuFStannd();
						window.janelaFuncionarioStand.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});*/
			//is.menuFuncionarioStand();
			/*i.menuF();
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
				break;
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
}while(verf);}*/

}