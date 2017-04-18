package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Ff {

	private JFrame janelaFuncionarioStand;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ff window = new Ff();
					window.janelaFuncionarioStand.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ff() {
		menuFuncionarioStand();
	}

	/**
	 * Initialize the contents of the frame.
	 */
public void menuFuncionarioStand() {
		
		janelaFuncionarioStand = new JFrame();
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
}
