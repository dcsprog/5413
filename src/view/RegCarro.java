package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import misc.MockupData;
import java.awt.Font;

public class RegCarro {

	private JFrame janelaComprarCarro;
	static MockupData bd;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegCarro window = new RegCarro();
					window.janelaComprarCarro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegCarro() {
		initialize();
		bd = new MockupData();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		janelaComprarCarro = new JFrame();
		janelaComprarCarro.getContentPane().setBackground(SystemColor.desktop);
		
		JLabel lblNomeStand = new JLabel(bd.reg.getNomeStand());
		lblNomeStand.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNomeStand.setForeground(SystemColor.textHighlightText);
		GroupLayout groupLayout = new GroupLayout(janelaComprarCarro.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(204)
					.addComponent(lblNomeStand)
					.addContainerGap(236, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(37)
					.addComponent(lblNomeStand)
					.addContainerGap(305, Short.MAX_VALUE))
		);
		janelaComprarCarro.getContentPane().setLayout(groupLayout);
		janelaComprarCarro.setBounds(100, 100, 597, 409);
		janelaComprarCarro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
