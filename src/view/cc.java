package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.GroupLayout.Alignment;

public class cc {

	private JFrame janelaPrincipal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cc window = new cc();
					window.janelaPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public cc() {
		 menuInicial();
	}

	/**
	 * Initialize the contents of the frame.
	 */
public void menuInicial() {
		
		janelaPrincipal = new JFrame();
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
				//menuBanco();
			}
		});
		
		btnBanco.setForeground(Color.DARK_GRAY);
		btnBanco.setFont(new Font("Century Gothic", Font.BOLD, 24));
		
		JButton btnStand = new JButton("STAND");
		btnStand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				janelaPrincipal.setVisible(false);
				//if(existe)
				//menuPrincipalStand();
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

}
