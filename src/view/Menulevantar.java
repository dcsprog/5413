package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import misc.MockupData;

public class Menulevantar {

	private JFrame janelaLevantar;
	static MockupData bd;
	static int idL;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menulevantar window = new Menulevantar();
					window.janelaLevantar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menulevantar() {
		menuLevantar(idL);
		bd = new MockupData();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void menuLevantar(int idL) {
		
		janelaLevantar = new JFrame();
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
				}else if(v <= bd.conta.get(idL).getSaldo()){
					//bd.conta.get(idL).setSaldo(bd.conta.get(idL).getSaldo()+v);
					//g.depositar(idL, v);
					janelaLevantar.setVisible(false);
					//menuBCliente(idL);
					//janelaBCliente.setVisible(true);
					
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

}
