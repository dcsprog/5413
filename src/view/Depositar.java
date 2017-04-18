package view;

import java.awt.EventQueue;
import java.awt.Window.Type;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import misc.MockupData;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Depositar {

	private JFrame janelaDepositar;
	private JTextField fvalor;
	private JButton btnNewButton;
	static MockupData bd = new MockupData();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Depositar window = new Depositar();
					window.janelaDepositar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Depositar() {
		int id=0;
		valorD(id);
	}

	/**
	 * Initialize the contents of the frame.
	 * System.out.println("INTRODUZA O NUMERO DE CONTA: ");
		int num = n.nextInt();
		System.out.println("INTRODUZA O VALOR: ");
		float valor = n.nextFloat();
		g.depositar(num, valor);
	 */
	private void valorD(int id) {
		janelaDepositar = new JFrame();
		janelaDepositar.getContentPane().setBackground(SystemColor.desktop);
		
		JLabel lblValor = new JLabel("VALOR:");
		lblValor.setForeground(SystemColor.textHighlightText);
		lblValor.setFont(new Font("Century Gothic", Font.BOLD, 11));
		
		fvalor = new JTextField();
		
		btnNewButton = new JButton("CONFIRMAR");
		btnNewButton.setFont(new Font("Century Gothic", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double v =Double.parseDouble(fvalor.getText());
				if(fvalor.getText()==null&& v<0){
					JOptionPane.showMessageDialog(null, "NENHUM VALOR INTRODUZIDO",null,JOptionPane.INFORMATION_MESSAGE);
				}else{
					bd.conta.get(id).setSaldo(bd.conta.get(id).getSaldo()+v);
					
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(janelaDepositar.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(108)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
					.addComponent(btnNewButton)
					.addContainerGap(15, Short.MAX_VALUE))
		);
		janelaDepositar.getContentPane().setLayout(groupLayout);
		janelaDepositar.setBounds(100, 100, 434, 141);
		janelaDepositar.setType(Type.UTILITY);
		janelaDepositar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
}
