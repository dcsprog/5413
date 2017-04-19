package view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout.Alignment;
import java.awt.SystemColor;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;

import controller.GestaoConta;
import misc.MockupData;

public class Transferir {

	private JFrame janelaTransferir;
	static MockupData bd;
	int idL;
	private JTextField textField;
	static GestaoConta g;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Transferir window = new Transferir();
					window.janelaTransferir.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Transferir() {
		transferirsss(idL);
		bd = new MockupData();
		g = new GestaoConta();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void transferirsss(int idL) {
		
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
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnConfirmar = new JButton("CONFIRMAR");
		btnConfirmar.setFont(new Font("Century Gothic", Font.BOLD, 11));
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double v = Double.parseDouble(fvalor.getText());
				if(fvalor.getText()==null&& v<0){
					JOptionPane.showMessageDialog(null, "NENHUM VALOR INTRODUZIDO",null,JOptionPane.INFORMATION_MESSAGE);
				}else if(v <= bd.conta.get(idL).getSaldo()){
					g.transferir(idL, Integer.parseInt(lblNumero.getText()),v);
					janelaTransferir.setVisible(false);
					//menuBCliente(idL);
					
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
}
			
			
