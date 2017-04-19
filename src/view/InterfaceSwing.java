package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;

import javax.swing.JButton;
import javax.swing.UIManager;

import application.ATM;
import controller.GestaoConta;
import controller.GestaoStand;
import misc.MockupData;
import model.Carro;
import model.Conta;
import model.Pessoa;
import model.Stand;

import java.awt.SystemColor;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;

public class InterfaceSwing {

	private JFrame janelaStand;
	private JFrame janelaPrincipal;
	private JFrame janelaPrincipalStand;
	private JFrame janelaFuncStand;
	private JFrame janelaFuncionarioStand;
	private JFrame janelaPBanco;
	private JFrame janelaFuncBanco;
	private JFrame janelaCliBanco;
	private JFrame janelaBCliente;
	private JFrame janelaListarConta;
	private JFrame janelaLogin;
	private JFrame janelaDepositar;
	private JFrame janelaRegStand;
	private JFrame janelaLevantar;
	private JFrame janelaTransferir;
	private JFrame janelaComprarCarro;
	private JFrame janelaVenderCarro;
	private JTextField textFieldNome;
	private JTextField textFieldNumero;
	private JTextField textFieldSaldo;
	private JTextField textFieldNomeVerf;
	private JTextField textFieldNomeLogin;
	private JTextField fvalor;
	private JTextField txtNome, txtMorada, txtTelefone, txtNif;
	private JPasswordField passwordField;
	private JPasswordField passwordFieldC;
	private JPasswordField passwordFieldLogin;
	
	static int id;
	static int idC;
	//static int idLog;
	//static int cont=0;
	static MockupData bd;
	static GestaoConta g;
	static GestaoStand gs;
	
	public InterfaceSwing() {
		bd = new MockupData();
		g = new GestaoConta();
		gs = new GestaoStand();
	}
	
	
	public void menuInicial() {
		
		janelaPrincipal = new JFrame();
		janelaPrincipal.setResizable(false);
		janelaPrincipal.setType(Type.UTILITY);
		janelaPrincipal.getContentPane().setBackground(SystemColor.desktop);
		janelaPrincipal.setBounds(100, 100, 450, 300);
		janelaPrincipal.setLocationRelativeTo(null);
		janelaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		janelaPrincipal.setVisible(true);
		
		JButton btnBanco = new JButton("BANCO");
		btnBanco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				janelaPrincipal.setVisible(false);
				menuBanco();
			}
		});
		
		btnBanco.setForeground(Color.DARK_GRAY);
		btnBanco.setFont(new Font("Century Gothic", Font.BOLD, 24));
		
		JButton btnStand = new JButton("STAND");
		btnStand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				janelaPrincipal.setVisible(false);
				menuPrincipalStand();
			}
		});
	
		btnStand.setForeground(Color.DARK_GRAY);
		btnStand.setFont(new Font("Century Gothic", Font.BOLD, 24));
		
		JButton btnNewButton = new JButton("FECHAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		btnNewButton.setFont(new Font("Century Gothic", Font.BOLD, 24));
		btnNewButton.setForeground(Color.DARK_GRAY);
		GroupLayout groupLayout = new GroupLayout(janelaPrincipal.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(48)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnStand)
							.addGap(116)
							.addComponent(btnBanco, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(42))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(79)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnStand)
						.addComponent(btnBanco))
					.addGap(60)
					.addComponent(btnNewButton)
					.addContainerGap(60, Short.MAX_VALUE))
		);
		janelaPrincipal.getContentPane().setLayout(groupLayout);
	}

	
	///AQUI COMECA O CODIGO DAS INTERFACES DO STAND
	
	public void menuPrincipalStand() {
		
		janelaPrincipalStand = new JFrame();
		janelaPrincipalStand.setResizable(false);
		janelaPrincipalStand.setType(Type.UTILITY);
		janelaPrincipalStand.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		janelaPrincipalStand.setResizable(false);
		janelaPrincipalStand.getContentPane().setForeground(Color.WHITE);
		janelaPrincipalStand.getContentPane().setBackground(Color.BLACK);
		janelaPrincipalStand.setBounds(100, 100, 450, 300);
		janelaPrincipalStand.setLocationRelativeTo(null);
		janelaPrincipalStand.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		if(bd.existe==false){
			janelaPrincipalStand.setVisible(false);
			menuRegStand();
		}else{
			janelaPrincipalStand.setVisible(true);
		}
		
		JLabel lblNewLabel = new JLabel("BEM VINDO AO STAND TPSI");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 24));
		
		JButton btnFuncionario = new JButton("FUNCIONARIO");
		btnFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				janelaPrincipalStand.setVisible(false);
				menuFuncionarioStand();
			}
		});
		btnFuncionario.setFont(new Font("Century Gothic", Font.BOLD, 11));
		
		JButton btnCliente = new JButton("CLIENTE");
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				janelaPrincipalStand.setVisible(false);
				menuStandCli();
			}
		});
		btnCliente.setFont(new Font("Century Gothic", Font.BOLD, 11));
		
		JButton btnNewButton = new JButton("SAIR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				janelaPrincipalStand.setVisible(false);
				menuInicial();
			}
		});
		
		btnNewButton.setFont(new Font("Century Gothic", Font.BOLD, 11));
		
		
		GroupLayout groupLayout = new GroupLayout(janelaPrincipalStand.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(79)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnFuncionario, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
							.addGap(50)
							.addComponent(btnCliente, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
					.addGap(62))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addComponent(lblNewLabel)
					.addGap(70)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnFuncionario)
						.addComponent(btnCliente))
					.addGap(42)
					.addComponent(btnNewButton)
					.addContainerGap(50, Short.MAX_VALUE))
		);
		janelaPrincipalStand.getContentPane().setLayout(groupLayout);
		
	}

	
	public void menuStandCli() {
		
		janelaStand = new JFrame();
		janelaStand.setType(Type.UTILITY);
		janelaStand.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		janelaStand.setResizable(false);
		janelaStand.getContentPane().setForeground(Color.WHITE);
		janelaStand.getContentPane().setBackground(Color.BLACK);
		janelaStand.setBounds(100, 100, 450, 300);
		janelaStand.setLocationRelativeTo(null);
		janelaStand.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		janelaStand.setVisible(true);
		
		JLabel lblNewLabel = new JLabel("BEM VINDO AO STAND TPSI");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 24));
		
		JButton btnComprarCarro = new JButton("COMPRAR CARRO");
		btnComprarCarro.setFont(new Font("Century Gothic", Font.BOLD, 11));
		btnComprarCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				janelaStand.setVisible(false);
				venderCarroCli();
			}
		});
		btnComprarCarro.setForeground(Color.DARK_GRAY);
		//btnComprarCarro.setBackground(Color.WHITE);
		
		JButton btnVenderCarro = new JButton("VENDER CARRO");
		btnVenderCarro.setFont(new Font("Century Gothic", Font.BOLD, 11));
		btnVenderCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				janelaStand.setVisible(false);
				comprarCarroCli();
			}
		});
		btnVenderCarro.setForeground(Color.DARK_GRAY);
		//btnVenderCarro.setBackground(Color.WHITE);
		
		JButton btnNewButton = new JButton("SAIR");
		btnNewButton.setFont(new Font("Century Gothic", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				janelaStand.setVisible(false);
				menuPrincipalStand();
			}
		});
		//btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setForeground(Color.DARK_GRAY);
		GroupLayout groupLayout = new GroupLayout(janelaStand.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(69)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(btnComprarCarro, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
							.addComponent(btnVenderCarro, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(65))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(34)
					.addComponent(lblNewLabel)
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnComprarCarro)
						.addComponent(btnVenderCarro))
					.addGap(66)
					.addComponent(btnNewButton)
					.addContainerGap(55, Short.MAX_VALUE))
		);
		janelaStand.getContentPane().setLayout(groupLayout);
	}
	
	
	public void menuFuncionarioStand() {
		
		janelaFuncionarioStand = new JFrame();
		janelaFuncionarioStand.setResizable(false);
		janelaFuncionarioStand.setType(Type.UTILITY);
		janelaFuncionarioStand.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		janelaFuncionarioStand.setResizable(false);
		janelaFuncionarioStand.getContentPane().setForeground(Color.WHITE);
		janelaFuncionarioStand.getContentPane().setBackground(Color.BLACK);
		janelaFuncionarioStand.setBounds(100, 100, 450, 300);
		janelaFuncionarioStand.setLocationRelativeTo(null);
		janelaFuncionarioStand.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		janelaFuncionarioStand.setVisible(true);
		
		JLabel lblNewLabel = new JLabel("BEM VINDO AO STAND TPSI");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 24));
		
		JButton btnVerConta = new JButton("VERIFICAR CONTA");
		btnVerConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				janelaFuncionarioStand.setVisible(false);
				login();
			}
		});
		btnVerConta.setFont(new Font("Century Gothic", Font.BOLD, 11));
		
		JButton btnListarConta = new JButton("VERIFICAR VENDAS");
		btnListarConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnListarConta.setFont(new Font("Century Gothic", Font.BOLD, 11));
		
		JButton btnNewButton = new JButton("SAIR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				janelaFuncionarioStand.setVisible(false);
				menuPrincipalStand();
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Century Gothic", Font.BOLD, 11));
		
		JButton btnVerificarCompras = new JButton("VERIFICAR COMPRAS");
		btnVerificarCompras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVerificarCompras.setFont(new Font("Century Gothic", Font.BOLD, 11));
		
		
		GroupLayout groupLayout = new GroupLayout(janelaFuncionarioStand.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(79)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnVerConta, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnVerificarCompras, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnListarConta, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addComponent(lblNewLabel))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addComponent(lblNewLabel)
					.addGap(47)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnListarConta)
						.addComponent(btnVerificarCompras))
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnVerConta))
					.addContainerGap(85, Short.MAX_VALUE))
		);
		janelaFuncionarioStand.getContentPane().setLayout(groupLayout);
		
	
	}


	private void menuRegStand() {
		
	janelaRegStand = new JFrame();
	janelaRegStand.setResizable(false);
	janelaRegStand.setType(Type.UTILITY);
	janelaRegStand.getContentPane().setBackground(SystemColor.desktop);
	janelaRegStand.setBounds(100, 100, 450, 319);
	janelaRegStand.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	janelaRegStand.setLocationRelativeTo(null);
	janelaRegStand.setVisible(true);
	
	JLabel lblNewLabel = new JLabel("REGISTO DO STAND");
	lblNewLabel.setForeground(SystemColor.textHighlightText);
	lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 24));
	
	JLabel lblNome = new JLabel("NOME:");
	lblNome.setFont(new Font("Century Gothic", Font.BOLD, 11));
	lblNome.setForeground(SystemColor.textHighlightText);
	
	JLabel lblNif = new JLabel("NIF:");
	lblNif.setForeground(Color.WHITE);
	lblNif.setFont(new Font("Century Gothic", Font.BOLD, 11));
	
	JLabel lblMorada = new JLabel("MORADA:");
	lblMorada.setForeground(Color.WHITE);
	lblMorada.setFont(new Font("Century Gothic", Font.BOLD, 11));
	
	JLabel lblTelefone = new JLabel("TELEFONE:");
	lblTelefone.setForeground(Color.WHITE);
	lblTelefone.setFont(new Font("Century Gothic", Font.BOLD, 11));
	
	txtNome = new JTextField();
	txtNome.setFont(new Font("Century Gothic", Font.BOLD, 11));
	txtNome.setToolTipText("");
	txtNome.setColumns(10);
	
	txtMorada = new JTextField();
	txtMorada.setToolTipText("");
	txtMorada.setFont(new Font("Century Gothic", Font.BOLD, 11));
	txtMorada.setColumns(10);
	
	txtTelefone = new JTextField();
	txtTelefone.setToolTipText("");
	txtTelefone.setFont(new Font("Century Gothic", Font.BOLD, 11));
	txtTelefone.setColumns(10);
	
	txtNif = new JTextField();
	txtNif.setToolTipText("");
	txtNif.setFont(new Font("Century Gothic", Font.BOLD, 11));
	txtNif.setColumns(10);
	
	JButton btnREGSTAND = new JButton("REGISTAR");
	btnREGSTAND.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			if(!txtNome.getText().isEmpty()&&!txtMorada.getText().isEmpty()&&!txtTelefone.getText().isEmpty()&&!txtNif.getText().isEmpty()){
				janelaRegStand.setVisible(false);
				gs.addStand(Integer.parseInt(txtNif.getText()),txtNome.getText(),txtMorada.getText(),txtTelefone.getText());
				bd.existe=true;
				/*System.out.println(bd.reg.getNumeroNIF()+bd.reg.getNomeStand()+
						bd.reg.getMorada()+bd.reg.getTelefone()+bd.reg.getContaBancaria().getPessoa().getNome());
				janelaRegStand.setVisible(false);*/
				menuPrincipalStand();
			}else{
				JOptionPane.showMessageDialog(null, "TODOS OS CAMPOS SAO DE PREENCHIMENTO OBRIGATORIO!",null,JOptionPane.INFORMATION_MESSAGE);
			}
			
			
		}
	});
	GroupLayout groupLayout = new GroupLayout(janelaRegStand.getContentPane());
	groupLayout.setHorizontalGroup(
		groupLayout.createParallelGroup(Alignment.LEADING)
			.addGroup(groupLayout.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
					.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblNewLabel))
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(53)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addComponent(lblNif, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
							.addComponent(lblMorada, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
							.addComponent(lblTelefone, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
							.addComponent(lblNome, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(txtTelefone, Alignment.LEADING)
							.addComponent(txtMorada, Alignment.LEADING)
							.addComponent(txtNome, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
							.addComponent(btnREGSTAND, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(txtNif, Alignment.LEADING))))
				.addContainerGap(92, Short.MAX_VALUE))
	);
	groupLayout.setVerticalGroup(
		groupLayout.createParallelGroup(Alignment.LEADING)
			.addGroup(groupLayout.createSequentialGroup()
				.addGap(24)
				.addComponent(lblNewLabel)
				.addGap(26)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
					.addGroup(groupLayout.createSequentialGroup()
						.addComponent(lblNome)
						.addGap(24)
						.addComponent(lblMorada, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createSequentialGroup()
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(txtMorada, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
					.addComponent(lblTelefone, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addComponent(txtTelefone, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
					.addComponent(lblNif, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addComponent(txtNif, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addComponent(btnREGSTAND)
				.addContainerGap(20, Short.MAX_VALUE))
	);
	janelaRegStand.getContentPane().setLayout(groupLayout);
	
	}
	
	
	
	private void comprarCarroCli() {
		
		janelaComprarCarro = new JFrame();
		janelaComprarCarro.setType(Type.UTILITY);
		janelaComprarCarro.getContentPane().setBackground(SystemColor.desktop);
		janelaComprarCarro.setResizable(false);
		janelaComprarCarro.setLocationRelativeTo(null);
		
		janelaComprarCarro.setVisible(true);
		
		JLabel lblNomeStand = new JLabel("STAND "+bd.reg.getNomeStand()+" ,LDA");
		lblNomeStand.setFont(new Font("Century Gothic", Font.BOLD, 24));
		lblNomeStand.setForeground(SystemColor.textHighlightText);
		
		JLabel lblNewLabel = new JLabel("MARCA");
		lblNewLabel.setForeground(SystemColor.textHighlightText);
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 11));
		
		JLabel lblModelo = new JLabel("MODELO");
		lblModelo.setForeground(Color.WHITE);
		lblModelo.setFont(new Font("Century Gothic", Font.BOLD, 11));
		
		JLabel lblPlaca = new JLabel("PLACA");
		lblPlaca.setForeground(Color.WHITE);
		lblPlaca.setFont(new Font("Century Gothic", Font.BOLD, 11));
		
		JLabel lblPreco = new JLabel("PRECO");
		lblPreco.setForeground(Color.WHITE);
		lblPreco.setFont(new Font("Century Gothic", Font.BOLD, 11));
		
		JTextField textFieldMarca = new JTextField();
		textFieldMarca.setColumns(10);
		
		JTextField textFieldModelo = new JTextField();
		textFieldModelo.setColumns(10);
		
		JTextField textFieldPlaca = new JTextField();
		textFieldPlaca.setColumns(10);
		
		JTextField textFieldPreco = new JTextField();
		textFieldPreco.setColumns(10);
		
		JButton btnNewButton = new JButton("CONFIRMAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Conta c = null;
				for(Conta d:bd.conta){
					if(bd.reg.getContaBancaria().getNumeroConta()==d.getNumeroConta()){
						c=d;
					}
				}
				Stand s = new Stand(bd.reg.getNumeroNIF(),bd.reg.getNomeStand(),bd.reg.getMorada(),bd.reg.getTelefone(),c);
				gs.comprarCarroDoCli(textFieldMarca.getText(), textFieldModelo.getText(), textFieldPlaca.getText(), Double.parseDouble(textFieldPreco.getText()), s);
				janelaComprarCarro.setVisible(false);
				menuStandCli();
			}
		});
		
		JButton btnAnular = new JButton("ANULAR");
		btnAnular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				janelaComprarCarro.setVisible(false);
				menuStandCli();
			}
		});
		GroupLayout groupLayout = new GroupLayout(janelaComprarCarro.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(204)
							.addComponent(lblNomeStand))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(80)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnAnular, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
									.addGap(18)
									.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblPlaca, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(textFieldPlaca, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(lblPreco, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(textFieldMarca, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(lblModelo, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(textFieldModelo, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
										.addComponent(textFieldPreco, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE))))
							.addGap(6)))
					.addGap(69))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(37)
					.addComponent(lblNomeStand)
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel)
							.addComponent(textFieldMarca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblModelo, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
							.addComponent(textFieldModelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(textFieldPreco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblPreco, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblPlaca, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
							.addComponent(textFieldPlaca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAnular)
						.addComponent(btnNewButton))
					.addContainerGap(46, Short.MAX_VALUE))
		);
		janelaComprarCarro.getContentPane().setLayout(groupLayout);
		janelaComprarCarro.setBounds(100, 100, 597, 276);
		janelaComprarCarro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	private void venderCarroCli() {
		
		janelaVenderCarro = new JFrame();
		janelaVenderCarro.setType(Type.UTILITY);
		janelaVenderCarro.getContentPane().setBackground(SystemColor.desktop);
		janelaVenderCarro.setBounds(100, 100, 597, 379);
		janelaVenderCarro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janelaVenderCarro.setResizable(false);
		janelaVenderCarro.setLocationRelativeTo(null);
	
		janelaVenderCarro.setVisible(true);
	
		JLabel lblNomeStand = new JLabel("STAND "+bd.reg.getNomeStand()+" ,LDA");
		lblNomeStand.setFont(new Font("Century Gothic", Font.BOLD, 24));
		lblNomeStand.setForeground(SystemColor.textHighlightText);
	
		JLabel lblNewLabel = new JLabel("MARCA");
		lblNewLabel.setForeground(SystemColor.textHighlightText);
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 11));
	
		JLabel lblModelo = new JLabel("MODELO");
		lblModelo.setForeground(Color.WHITE);
		lblModelo.setFont(new Font("Century Gothic", Font.BOLD, 11));
	
		JLabel lblPlaca = new JLabel("PLACA");
		lblPlaca.setForeground(Color.WHITE);
		lblPlaca.setFont(new Font("Century Gothic", Font.BOLD, 11));
	
		JLabel lblPreco = new JLabel("PRECO");
		lblPreco.setForeground(Color.WHITE);
		lblPreco.setFont(new Font("Century Gothic", Font.BOLD, 11));
	
		JTextField textFieldMarca = new JTextField();
		textFieldMarca.setColumns(10);
	
		JTextField textFieldModelo = new JTextField();
		textFieldModelo.setColumns(10);
	
		JTextField textFieldPlaca = new JTextField();
		textFieldPlaca.setColumns(10);
	
		JTextField textFieldPreco = new JTextField();
		textFieldPreco.setColumns(10);
	
	
		JLabel lblDadosDaConta = new JLabel("DADOS DA CONTA BANCARIA");
		lblDadosDaConta.setForeground(Color.WHITE);
		lblDadosDaConta.setFont(new Font("Century Gothic", Font.BOLD, 11));
	
		JLabel lblNome = new JLabel("NOME:");
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Century Gothic", Font.BOLD, 11));
	
		JTextField txtNomeBanco = new JTextField();
		txtNomeBanco.setColumns(10);
	
		JLabel lblNumero = new JLabel("NUMERO");
		lblNumero.setForeground(Color.WHITE);
		lblNumero.setFont(new Font("Century Gothic", Font.BOLD, 11));
	
		JTextField txtNumeroBanco = new JTextField();
		txtNumeroBanco.setColumns(10);
	
		JLabel lblDadosDoVeiculo = new JLabel("DADOS DO VEICULO");
		lblDadosDoVeiculo.setForeground(Color.WHITE);
		lblDadosDoVeiculo.setFont(new Font("Century Gothic", Font.BOLD, 11));
	
		if(!bd.carrosStand.isEmpty()){
			textFieldMarca.setText(bd.carrosStand.get(0).getMarca());
			textFieldModelo.setText(bd.carrosStand.get(0).getModelo());
			textFieldPlaca.setText(bd.carrosStand.get(0).getPlaca());
			textFieldPreco.setText(Double.toString(bd.carrosStand.get(0).getPreco()));
		}else{
			janelaVenderCarro.setVisible(false);
			JOptionPane.showMessageDialog(null, "NAO EXISTEM MAIS REGISTOS!",null,JOptionPane.INFORMATION_MESSAGE);
			//menuBanco();
		}
	
		JButton btnNewButton = new JButton("CONFIRMAR");
		btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			
			//String marca, String modelo, String placa, double preco, Stand s,int numConta
			Conta cliente = null;
			for(Conta cli:bd.conta){
				int n =Integer.parseInt(txtNumeroBanco.getText());
				int n2 = cli.getNumeroConta();
				if(txtNomeBanco.getText().equals(cli.getPessoa().getNome())&& n==n2){
					cliente=cli;
				}
			}
			
			Conta c = null;
			for(Conta d:bd.conta){
				if(bd.reg.getContaBancaria().getNumeroConta()==d.getNumeroConta()){
					c=d;
				}
			}
			Stand s = new Stand(bd.reg.getNumeroNIF(),bd.reg.getNomeStand(),bd.reg.getMorada(),bd.reg.getTelefone(),c);
			gs.venderCarroAoCli(bd.carrosStand.get(idC).getIdCar(),textFieldMarca.getText(), textFieldModelo.getText(), textFieldPlaca.getText(), Double.parseDouble(textFieldPreco.getText()), s, cliente.getNumeroConta());
			//gs.comprarCarroDoCli(textFieldMarca.getText(), textFieldModelo.getText(), textFieldPlaca.getText(), Double.parseDouble(textFieldPreco.getText()), s);
			janelaVenderCarro.setVisible(false);
			menuStandCli();
		}
		});
	
		JButton btnAnular = new JButton("ANULAR");
		btnAnular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			janelaVenderCarro.setVisible(false);
			menuStandCli();
			}
		});
	
		JButton btnAnterior = new JButton("ANTERIOR");
		btnAnterior.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				if(idC<bd.carrosStand.size()){
					idC--;
					for(Carro c: bd.carrosStand){
						if(idC==bd.carrosStand.get(idC).getIdCar()){
							textFieldMarca.setText(bd.carrosStand.get(idC).getMarca());
							textFieldModelo.setText(bd.carrosStand.get(idC).getModelo());
							textFieldPlaca.setText(bd.carrosStand.get(idC).getPlaca());
							textFieldPreco.setText(Double.toString(bd.carrosStand.get(idC).getPreco()));
						}
					}
				}else{
					JOptionPane.showMessageDialog(null, "NAO EXISTEM MAIS CARROS!",null,JOptionPane.INFORMATION_MESSAGE);
				}
			}
			catch (Exception e1) {
				e1.getCause();
			}
			
		
		}
	});
	
	JButton btnProximo = new JButton("PROXIMO");
	btnProximo.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			try {
			if(idC<bd.carrosStand.size()){
				idC++;
				for(Carro c: bd.carrosStand){
					if(idC==bd.carrosStand.get(idC).getIdCar()){
						textFieldMarca.setText(bd.carrosStand.get(idC).getMarca());
						textFieldModelo.setText(bd.carrosStand.get(idC).getModelo());
						textFieldPlaca.setText(bd.carrosStand.get(idC).getPlaca());
						textFieldPreco.setText(Double.toString(bd.carrosStand.get(idC).getPreco()));
					}
				}
			}else{
				JOptionPane.showMessageDialog(null, "NAO EXISTEM MAIS CARROS!",null,JOptionPane.INFORMATION_MESSAGE);
			}
		}
		catch (Exception e1) {
			e1.getCause();
		}
		}
	});
	
	GroupLayout groupLayout = new GroupLayout(janelaVenderCarro.getContentPane());
	groupLayout.setHorizontalGroup(
		groupLayout.createParallelGroup(Alignment.LEADING)
			.addGroup(groupLayout.createSequentialGroup()
				.addContainerGap(171, Short.MAX_VALUE)
				.addComponent(lblNomeStand)
				.addGap(146))
			.addGroup(groupLayout.createSequentialGroup()
				.addGap(80)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addComponent(lblDadosDoVeiculo, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
					.addGroup(groupLayout.createSequentialGroup()
						.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtNomeBanco, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(lblNumero, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(txtNumeroBanco, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
						.addGap(76))
					.addGroup(groupLayout.createSequentialGroup()
						.addComponent(lblDadosDaConta)
						.addContainerGap())
					.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblPlaca, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(textFieldPlaca, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(lblPreco, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(textFieldMarca, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(lblModelo, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(textFieldModelo, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
									.addComponent(textFieldPreco, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)))
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(btnAnterior, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnAnular, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
								.addGap(26)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(btnProximo, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
									.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))))
						.addGap(75))))
	);
	groupLayout.setVerticalGroup(
		groupLayout.createParallelGroup(Alignment.LEADING)
			.addGroup(groupLayout.createSequentialGroup()
				.addGap(23)
				.addComponent(lblNomeStand)
				.addGap(27)
				.addComponent(lblDadosDaConta, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addComponent(txtNomeBanco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(lblNumero, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addComponent(txtNumeroBanco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(26)
				.addComponent(lblDadosDoVeiculo, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textFieldMarca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblModelo, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldModelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldPreco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPreco, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPlaca, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldPlaca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(17)
						.addComponent(btnAnterior))
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(18)
						.addComponent(btnProximo)))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
					.addComponent(btnAnular)
					.addComponent(btnNewButton))
				.addGap(24))
	);
	janelaVenderCarro.getContentPane().setLayout(groupLayout);
	
}


///AQUI COMECA O CODIGO DAS INTERFACES DO BANCO
	
	public void menuBanco(){
		
		janelaPBanco = new JFrame();
		janelaPBanco.setResizable(false);
		janelaPBanco.setType(Type.UTILITY);
		janelaPBanco.getContentPane().setForeground(SystemColor.text);
		janelaPBanco.getContentPane().setBackground(SystemColor.desktop);
		janelaPBanco.setBounds(100, 100, 450, 300);
		janelaPBanco.setLocationRelativeTo(null);
		janelaPBanco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		janelaPBanco.setVisible(true);
		
		JLabel lblNewLabel = new JLabel("BEM VINDO AO BANCO TPSI");
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 24));
		lblNewLabel.setForeground(SystemColor.textHighlightText);
		
		JButton btnFuncionario = new JButton("FUNCIONARIO");
		btnFuncionario.setFont(new Font("Century Gothic", Font.BOLD, 11));
		btnFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				janelaPBanco.setVisible(false);
				menuFuncBanco();
			}
		});
		
		JButton btnCliente = new JButton("CLIENTE");
		btnCliente.setFont(new Font("Century Gothic", Font.BOLD, 11));
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				janelaPBanco.setVisible(false);
				//menuBCliente();
				login();
			}
		});
		
		JButton btnSair = new JButton("SAIR");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				janelaPBanco.setVisible(false);
				menuInicial();
			}
		});
		btnSair.setFont(new Font("Century Gothic", Font.BOLD, 11));
		GroupLayout groupLayout = new GroupLayout(janelaPBanco.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(61)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSair, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnFuncionario, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
							.addComponent(btnCliente, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(49, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(lblNewLabel)
					.addGap(56)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnFuncionario)
						.addComponent(btnCliente))
					.addGap(48)
					.addComponent(btnSair)
					.addContainerGap(57, Short.MAX_VALUE))
		);
		janelaPBanco.getContentPane().setLayout(groupLayout);
	}

	
	public void menuFuncBanco() {
		
		janelaFuncBanco = new JFrame();
		janelaFuncBanco.setResizable(false);
		janelaFuncBanco.setType(Type.UTILITY);
		janelaFuncBanco.getContentPane().setForeground(SystemColor.text);
		janelaFuncBanco.getContentPane().setBackground(SystemColor.desktop);
		janelaFuncBanco.setBounds(100, 100, 450, 300);
		janelaFuncBanco.setLocationRelativeTo(null);
		janelaFuncBanco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janelaFuncBanco.setVisible(true);
		
		JLabel lblBemVindoAo = new JLabel("BEM VINDO AO BANCO TPSI");
		lblBemVindoAo.setForeground(SystemColor.textHighlightText);
		lblBemVindoAo.setFont(new Font("Century Gothic", Font.BOLD, 24));
		
		JButton btnCriarConta = new JButton("CRIAR CONTA");
		btnCriarConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				janelaFuncBanco.setVisible(false);
				regCli();
			}
		});
		btnCriarConta.setFont(new Font("Century Gothic", Font.BOLD, 11));
		btnCriarConta.setForeground(Color.DARK_GRAY);
		
		JButton btnListarConta = new JButton("LISTAR CONTA");
		btnListarConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				janelaFuncBanco.setVisible(false);
				menuListarConta();
			}
		});
		btnListarConta.setForeground(Color.DARK_GRAY);
		btnListarConta.setFont(new Font("Century Gothic", Font.BOLD, 11));
		
		JButton btnNewButton = new JButton("SAIR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				janelaFuncBanco.setVisible(false);
				menuBanco();
			}
		});
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setFont(new Font("Century Gothic", Font.BOLD, 11));
		
	
		
		GroupLayout groupLayout = new GroupLayout(janelaFuncBanco.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(61)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btnCriarConta, GroupLayout.PREFERRED_SIZE,  131, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
							.addComponent(btnListarConta, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblBemVindoAo, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(49, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(lblBemVindoAo)
					.addGap(56)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCriarConta)
						.addComponent(btnListarConta))
					.addGap(48)
					.addComponent(btnNewButton)
					.addContainerGap(57, Short.MAX_VALUE))
		);
		janelaFuncBanco.getContentPane().setLayout(groupLayout);
	}
	
	public void regCli() {

		janelaCliBanco = new JFrame();
		janelaCliBanco.setResizable(false);
		janelaCliBanco.setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		janelaCliBanco.getContentPane().setBackground(SystemColor.desktop);
		janelaCliBanco.setType(Type.UTILITY);
		janelaCliBanco.setBounds(100, 100, 434, 183);
		janelaCliBanco.setLocationRelativeTo(null);
		janelaCliBanco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janelaCliBanco.setVisible(true);
		
		JLabel lblNome = new JLabel("NOME:");
		lblNome.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblNome.setForeground(SystemColor.window);
		lblNome.setEnabled(true);
		
		textFieldNomeVerf = new JTextField();
		textFieldNomeVerf.setColumns(10);

		JLabel lblSenha = new JLabel("SENHA:");
		lblSenha.setFont(new Font("Century Gothic", Font.BOLD, 11));
		lblSenha.setForeground(SystemColor.window);
		
		
		JLabel lblCopiaSenha = new JLabel("COPIA SENHA:");
		lblCopiaSenha.setFont(new Font("Century Gothic", Font.BOLD, 11));
		lblCopiaSenha.setForeground(SystemColor.window);
		
		passwordField = new JPasswordField();
		passwordFieldC = new JPasswordField();
		
		JButton btnNewButton = new JButton("REGISTAR");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
					
				char[] pass = passwordField.getPassword();
				char[] passcopia = passwordFieldC.getPassword();
				String passString = new String(pass);
				String passStringC = new String(passcopia);
					if(passString.equals(passStringC)&&!textFieldNomeVerf.getText().isEmpty()&&!passwordField.toString().isEmpty()&&!passwordFieldC.toString().isEmpty()){
						janelaCliBanco.setVisible(false);
						g.addConta(textFieldNomeVerf.getText(),passString);
						JOptionPane.showMessageDialog(null, "CONTA REGISTADA COM SUCESSO!",null,JOptionPane.INFORMATION_MESSAGE);
						menuBanco();
					}else{
						//System.out.println("AS SENHAS INSERIDAS NAO CORRESPONDEM");
						JOptionPane.showMessageDialog(null, "INFORMACAO INCORRETA!",null,JOptionPane.INFORMATION_MESSAGE);
						passwordField.setText(null);
						passwordFieldC.setText(null);
					}
	
			}
		});
		btnNewButton.setFont(new Font("Century Gothic", Font.BOLD, 11));
		
		
		
		GroupLayout groupLayout = new GroupLayout(janelaCliBanco.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblSenha)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(lblCopiaSenha)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(passwordFieldC, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNome)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textFieldNomeVerf, GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)))
					.addGap(28))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(textFieldNomeVerf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSenha)
						.addComponent(passwordFieldC, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCopiaSenha)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnNewButton)
					.addContainerGap(25, Short.MAX_VALUE))
		);
		janelaCliBanco.getContentPane().setLayout(groupLayout);
		
		
	}
	
	private void menuListarConta() {
		
		janelaListarConta = new JFrame();
		janelaListarConta.setResizable(false);
		janelaListarConta.setType(Type.UTILITY);
		janelaListarConta.setBounds(100, 100, 479, 164);
		janelaListarConta.setLocationRelativeTo(null);
		janelaListarConta.getContentPane().setBackground(SystemColor.desktop);
		
		janelaListarConta.setVisible(true);
		
		JLabel lblNome = new JLabel("NOME:");
		lblNome.setFont(new Font("Century Gothic", Font.BOLD, 11));
		lblNome.setForeground(Color.WHITE);
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		
		
		JLabel lblNConta = new JLabel("N\u00BA CONTA: ");
		lblNConta.setFont(new Font("Century Gothic", Font.BOLD, 11));
		lblNConta.setForeground(Color.WHITE);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setColumns(10);
		
		JLabel lblSaldo = new JLabel("SALDO:");
		lblSaldo.setFont(new Font("Century Gothic", Font.BOLD, 11));
		lblSaldo.setForeground(Color.WHITE);
		
		textFieldSaldo = new JTextField();
		textFieldSaldo.setColumns(10);
		/*
		if(!bd.conta.isEmpty()){
			textFieldNome.setText(bd.conta.get(id).getPessoa().getNome());
			textFieldNumero.setText(Integer.toString(bd.conta.get(id).getNumeroConta()));
			textFieldSaldo.setText(Double.toString(bd.conta.get(id).getSaldo()));
		}else{
			janelaListarConta.setVisible(false);
			JOptionPane.showMessageDialog(null, "NAO EXISTEM MAIS REGISTOS!",null,JOptionPane.INFORMATION_MESSAGE);
			menuBanco();
		}*/
		if(!bd.conta.isEmpty()){
			textFieldNome.setText(bd.conta.get(0).getPessoa().getNome());
			textFieldNumero.setText(Integer.toString(bd.conta.get(0).getNumeroConta()));
			textFieldSaldo.setText(Double.toString(bd.conta.get(0).getSaldo()));
		}else{
			janelaListarConta.setVisible(false);
			JOptionPane.showMessageDialog(null, "NAO EXISTEM MAIS REGISTOS!",null,JOptionPane.INFORMATION_MESSAGE);
			menuBanco();
		}
		
		
		
		
		JButton btnProx = new JButton("PROXIMO");
		btnProx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(id<bd.conta.size()){
						id++;
						for(Conta c: bd.conta){
							if(id==bd.conta.get(id).getNumeroConta()){
								textFieldNome.setText(bd.conta.get(id).getPessoa().getNome());
								textFieldNumero.setText(Integer.toString(bd.conta.get(id).getNumeroConta()));
								textFieldSaldo.setText(Double.toString(bd.conta.get(id).getSaldo()));
							}
						}
					}else{
						JOptionPane.showMessageDialog(null, "NAO EXISTEM MAIS REGISTOS!",null,JOptionPane.INFORMATION_MESSAGE);
					}
				}
				catch (Exception e1) {
					e1.getCause();
				}
	
			}
		});
		
		JButton btnAnterior = new JButton("ANTERIOR");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					if(id>=0){
						id--;
						for(Conta c: bd.conta){
							if(id==bd.conta.get(id).getNumeroConta()){
								textFieldNome.setText(bd.conta.get(id).getPessoa().getNome());
								textFieldNumero.setText(Integer.toString(bd.conta.get(id).getNumeroConta()));
								textFieldSaldo.setText(Double.toString(bd.conta.get(id).getSaldo()));
							}
						}
					}else{
						JOptionPane.showMessageDialog(null, "NAO EXISTEM MAIS REGISTOS!",null,JOptionPane.INFORMATION_MESSAGE);
					}
					
				}catch(Exception e2){
					e2.getCause();
				}
				
			}	
		});
		
		JButton btnNewButton = new JButton("FECHAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				janelaListarConta.setVisible(false);
				menuBanco();
			}
		});
		GroupLayout groupLayout = new GroupLayout(janelaListarConta.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNome)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textFieldNome, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnAnterior, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnProx, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNConta)
								.addComponent(lblSaldo, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(textFieldNumero, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
								.addComponent(textFieldSaldo, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))))
					.addGap(24))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNConta)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNome)
								.addComponent(textFieldNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFieldSaldo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnAnterior)
								.addComponent(btnProx)
								.addComponent(lblSaldo))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton)
					.addContainerGap(14, Short.MAX_VALUE))
		);
		janelaListarConta.getContentPane().setLayout(groupLayout);
		janelaListarConta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void login() {
		
		janelaLogin = new JFrame();
		janelaLogin.setResizable(false);
		janelaLogin.setFont(new Font("Century Gothic", Font.BOLD, 12));
		janelaLogin.getContentPane().setBackground(SystemColor.desktop);
		janelaLogin.setBounds(100, 100, 434, 143);
		janelaLogin.setType(Type.UTILITY);
		janelaLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janelaLogin.setLocationRelativeTo(null);
		janelaLogin.setVisible(true);
		
		JLabel lblNome = new JLabel("NOME:");
		lblNome.setFont(new Font("Century Gothic", Font.BOLD, 11));
		lblNome.setForeground(SystemColor.textHighlightText);
		
		textFieldNomeLogin = new JTextField();
		textFieldNomeLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("SENHA:");
		lblSenha.setForeground(SystemColor.textHighlightText);
		lblSenha.setFont(new Font("Century Gothic", Font.BOLD, 11));
		
		passwordFieldLogin = new JPasswordField();
		
		JButton btnConfirmaLogin = new JButton("CONFIRMAR");
		btnConfirmaLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				
				char[] passLogin = passwordFieldLogin.getPassword();
				String passString = new String(passLogin);
				///String nomeLog = textFieldNomeLogin.getText();
				boolean correto=false;
				int contaList = 0;
				int cont = 0;
				//oufor(int c=0; c<bd.conta.size();c++)
				if(!MockupData.conta.isEmpty()){
					for(Conta c: bd.conta){
					//for (int i = 0; i < bd.conta.size(); i++) {
						//Conta c = bd.conta.get(i);
						//Conta c = iterator.next();
						//if(nomeLog.equals(c.getPessoa().getNome())&&passString.equals(c.getSenha()))
						//if(nomeLog.equals(bd.conta.get(i).getPessoa().getNome()) && passString.equals(bd.conta.get(i).getSenha()))
						if( textFieldNomeLogin.getText().equals(c.getPessoa().getNome())&&passString.equals(c.getSenha()))
						{
							//int idLog=bd.conta.get(i).getNumeroConta();
							int idLog = c.getNumeroConta();
							janelaLogin.setVisible(false);
							menuBCliente(idLog);
							//nomeLog =null;
							textFieldNomeLogin.setText(null);
							passLogin=null;
							passString=null;
							correto=true;
							
						}else{
							//System.out.println(nomeLog+passString+c.getPessoa().getNome()+c.getSenha());
							cont++;
							contaList++; 
							textFieldNomeLogin.setText(null);
							passwordFieldLogin.setText(null);
						}
					}
					if(cont==3){
						janelaLogin.setVisible(false);
						menuBanco();
						cont=0;
					}
					if(correto==false&&contaList==MockupData.conta.size()){
						JOptionPane.showMessageDialog(null, "AS DADOS INSERIDOS NAO CORRESPONDEM!",null,JOptionPane.INFORMATION_MESSAGE);
					}
				}else{
					JOptionPane.showMessageDialog(null, "NAO EXISTEM NENHUMA CONTA REGISTADA!",null,JOptionPane.INFORMATION_MESSAGE);
					janelaLogin.setVisible(false);
					menuBanco();
				}
			}
			
		});
		btnConfirmaLogin.setFont(new Font("Century Gothic", Font.BOLD, 11));
		

		
		GroupLayout groupLayout = new GroupLayout(janelaLogin.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnConfirmaLogin, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(lblNome)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldNomeLogin, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
							.addGap(16)
							.addComponent(lblSenha)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(passwordFieldLogin, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(37, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(passwordFieldLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSenha)
						.addComponent(textFieldNomeLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnConfirmaLogin)
					.addContainerGap(18, Short.MAX_VALUE))
		);
		janelaLogin.getContentPane().setLayout(groupLayout);
		
		
	}

	private void depositar(int idL) {
		
		janelaDepositar = new JFrame();
		janelaDepositar.setResizable(false);
		janelaDepositar.getContentPane().setBackground(SystemColor.desktop);
		janelaDepositar.setBounds(100, 100, 434, 141);
		janelaDepositar.setType(Type.UTILITY);
		janelaDepositar.setLocationRelativeTo(null);
		janelaDepositar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		janelaDepositar.setVisible(true);
		
		JLabel lblValor = new JLabel("VALOR:");
		lblValor.setForeground(SystemColor.textHighlightText);
		lblValor.setFont(new Font("Century Gothic", Font.BOLD, 11));
		
		fvalor = new JTextField();
		
		JButton btnConfirmar = new JButton("CONFIRMAR");
		btnConfirmar.setFont(new Font("Century Gothic", Font.BOLD, 11));
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double v =Double.parseDouble(fvalor.getText());
				if(fvalor.getText()==null&& v<0){
					JOptionPane.showMessageDialog(null, "NENHUM VALOR INTRODUZIDO",null,JOptionPane.INFORMATION_MESSAGE);
				}else{
					//bd.conta.get(idL).setSaldo(bd.conta.get(idL).getSaldo()+v);
					g.depositar(idL, v);
					janelaDepositar.setVisible(false);
					menuBCliente(idL);
					//janelaBCliente.setVisible(true);
					
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(janelaDepositar.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(108)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnConfirmar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(lblValor)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(fvalor, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(126, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblValor)
						.addComponent(fvalor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnConfirmar)
					.addContainerGap(15, Short.MAX_VALUE))
		);
		janelaDepositar.getContentPane().setLayout(groupLayout);

	}

	private void levantar(int idL) {
		
		janelaLevantar = new JFrame();
		janelaLevantar.setResizable(false);
		janelaLevantar.getContentPane().setBackground(SystemColor.desktop);
		janelaLevantar.setBounds(100, 100, 434, 141);
		janelaLevantar.setType(Type.UTILITY);
		janelaLevantar.setLocationRelativeTo(null);
		janelaLevantar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		janelaLevantar.setVisible(true);
		
		JLabel lblValor = new JLabel("VALOR:");
		lblValor.setForeground(SystemColor.textHighlightText);
		lblValor.setFont(new Font("Century Gothic", Font.BOLD, 11));
		
		JTextField fvalor = new JTextField();
		
		JButton btnConfirmar = new JButton("CONFIRMAR");
		btnConfirmar.setFont(new Font("Century Gothic", Font.BOLD, 11));
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double v = Double.parseDouble(fvalor.getText());
				if(fvalor.getText()==null&& v<0){
					JOptionPane.showMessageDialog(null, "NENHUM VALOR INTRODUZIDO",null,JOptionPane.INFORMATION_MESSAGE);
				}else{
					g.levantar(idL, v);
					janelaLevantar.setVisible(false);
					menuBCliente(idL);
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(janelaLevantar.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(108)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnConfirmar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(lblValor)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(fvalor, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(126, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblValor)
						.addComponent(fvalor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnConfirmar)
					.addContainerGap(15, Short.MAX_VALUE))
		);
		janelaLevantar.getContentPane().setLayout(groupLayout);
		
	}
	
	private void transferir(int idL) {
		
		janelaTransferir = new JFrame();
		janelaTransferir.setResizable(false);
		janelaTransferir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janelaTransferir.setType(Type.UTILITY);
		janelaTransferir.getContentPane().setBackground(SystemColor.desktop);
		janelaTransferir.setBounds(100, 100, 450, 181);
		janelaTransferir.setLocationRelativeTo(null);
		janelaTransferir.setVisible(true);

		JLabel lblValor = new JLabel("VALOR:");
		lblValor.setForeground(SystemColor.textHighlightText);
		lblValor.setFont(new Font("Century Gothic", Font.BOLD, 11));
		
		JTextField fvalor = new JTextField();
		
		JLabel lblNumero = new JLabel("NUMERO:");
		lblNumero.setFont(new Font("Dialog", Font.BOLD, 11));
		lblNumero.setForeground(SystemColor.textHighlightText);
		
		JTextField textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnConfirmar = new JButton("CONFIRMAR");
		btnConfirmar.setFont(new Font("Century Gothic", Font.BOLD, 11));
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double v = Double.parseDouble(fvalor.getText());
				if(fvalor.getText()==null&& v<0){
					JOptionPane.showMessageDialog(null, "NENHUM VALOR INTRODUZIDO",null,JOptionPane.INFORMATION_MESSAGE);
				}else if(v <= bd.conta.get(idL).getSaldo()){
					g.transferir(idL, Integer.parseInt(textField.getText()),v);
					janelaTransferir.setVisible(false);
					menuBCliente(idL);
					
				}
			}
		});
		
		
		GroupLayout groupLayout = new GroupLayout(janelaTransferir.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(82)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNumero)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
							.addComponent(lblValor)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(fvalor, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnConfirmar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(79))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(56, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblValor)
						.addComponent(fvalor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNumero)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnConfirmar)
					.addGap(40))
		);
		janelaTransferir.getContentPane().setLayout(groupLayout);
		
	}
	
	private void menuBCliente(int idLogin){
		
		janelaBCliente = new JFrame();
		janelaBCliente.setResizable(false);
		janelaBCliente.setType(Type.UTILITY);
		janelaBCliente.getContentPane().setBackground(SystemColor.desktop);
		janelaBCliente.setBounds(100, 100, 450, 300);
		janelaBCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janelaBCliente.setLocationRelativeTo(null);
		janelaBCliente.setVisible(true);
		
		JLabel lblApresentacao = new JLabel("BEM VINDO AO BANCO TPSI");
		lblApresentacao.setFont(new Font("Century Gothic", Font.BOLD, 24));
		lblApresentacao.setForeground(SystemColor.textHighlightText);
		
		JButton btnDepositar = new JButton("DEPOSITAR");
		btnDepositar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				janelaBCliente.setVisible(false);
				depositar(idLogin);
			}
		});
		btnDepositar.setFont(new Font("Century Gothic", Font.BOLD, 11));
		
		JButton btnLevantar = new JButton("LEVANTAR");
		btnLevantar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				janelaBCliente.setVisible(false);
				levantar(idLogin);
			}
		});
		btnLevantar.setFont(new Font("Century Gothic", Font.BOLD, 11));
		
		JButton btnTransferir = new JButton("TRANSFERIR");
		btnTransferir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				janelaBCliente.setVisible(false);
				transferir(idLogin);
			}
		});
		btnTransferir.setFont(new Font("Century Gothic", Font.BOLD, 11));
		
		JButton btnVerSaldo = new JButton("VER SALDO");
		btnVerSaldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVerSaldo.setFont(new Font("Century Gothic", Font.BOLD, 11));
		
		JButton btnNewButton = new JButton("FECHAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				janelaBCliente.setVisible(false);
				menuBanco();
			}
		});
		btnNewButton.setFont(new Font("Century Gothic", Font.BOLD, 11));
		
		GroupLayout groupLayout = new GroupLayout(janelaBCliente.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(63)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
						.addComponent(lblApresentacao, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnDepositar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(134))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnTransferir)
									.addGap(135)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnVerSaldo, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
								.addComponent(btnLevantar, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addGap(47))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addComponent(lblApresentacao)
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDepositar)
						.addComponent(btnLevantar))
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnTransferir)
						.addComponent(btnVerSaldo))
					.addGap(26)
					.addComponent(btnNewButton)
					.addContainerGap(49, Short.MAX_VALUE))
		);
		janelaBCliente.getContentPane().setLayout(groupLayout);
	}
	
	
	
	
	
	
}
