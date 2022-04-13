package com.ipartek.formacion.uf1844.presentacion;

import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EjemploSwingDesigner {

	private JFrame frame;
	private JTextField tfNombre;
	private JLabel lblResultado;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EjemploSwingDesigner window = new EjemploSwingDesigner();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EjemploSwingDesigner() {
		try {
			//UIManager.setLookAndFeel("com.sun.java." + "swing.plaf.motif.MotifLookAndFeel");// UIManager.getSystemLookAndFeelClassName());
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 402, 190);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{261, 74, 0};
		gbl_panel.rowHeights = new int[]{34, 46, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		tfNombre = new JTextField();
		GridBagConstraints gbc_tfNombre = new GridBagConstraints();
		gbc_tfNombre.fill = GridBagConstraints.BOTH;
		gbc_tfNombre.insets = new Insets(0, 0, 5, 5);
		gbc_tfNombre.gridx = 0;
		gbc_tfNombre.gridy = 0;
		panel.add(tfNombre, gbc_tfNombre);
		tfNombre.setColumns(10);
		
		JButton btnSaludar = new JButton("Saludar");
		GridBagConstraints gbc_btnSaludar = new GridBagConstraints();
		gbc_btnSaludar.insets = new Insets(0, 0, 5, 0);
		gbc_btnSaludar.fill = GridBagConstraints.BOTH;
		gbc_btnSaludar.gridx = 1;
		gbc_btnSaludar.gridy = 0;
		panel.add(btnSaludar, gbc_btnSaludar);
		btnSaludar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblResultado.setText("Hola " + tfNombre.getText());
			}
		});
		
		lblResultado = new JLabel("");
		GridBagConstraints gbc_lblResultado = new GridBagConstraints();
		gbc_lblResultado.gridwidth = 2;
		gbc_lblResultado.insets = new Insets(0, 0, 0, 5);
		gbc_lblResultado.fill = GridBagConstraints.BOTH;
		gbc_lblResultado.gridx = 0;
		gbc_lblResultado.gridy = 1;
		panel.add(lblResultado, gbc_lblResultado);
		lblResultado.setHorizontalAlignment(SwingConstants.LEFT);
	}

}
