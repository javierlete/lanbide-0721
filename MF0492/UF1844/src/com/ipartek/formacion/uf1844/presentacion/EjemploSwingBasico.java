package com.ipartek.formacion.uf1844.presentacion;

import java.awt.*;

import javax.swing.*;

public class EjemploSwingBasico {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Ejemplo");
		frame.setBounds(100, 200, 500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = frame.getContentPane();
		c.setLayout(new FlowLayout());
		
		JTextField tf = new JTextField(10);
		JButton b = new JButton("Saludar");
		JLabel l = new JLabel();
		
		c.add(tf);
		c.add(b);
		c.add(l);
		
		b.addActionListener(e -> 
			l.setText("Hola " + tf.getText()));
		/*
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				l.setText("Hola " + tf.getText());
			}
		});
		
		b.addActionListener(new EscuchadorBoton(l, tf));
		*/
		
		frame.setVisible(true);
	}
	/*
	static class EscuchadorBoton implements ActionListener {
		private JLabel l;
		private JTextField tf;
		
		public EscuchadorBoton(JLabel l, JTextField tf) {
			this.l = l;
			this.tf = tf;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			l.setText("Hola " + tf.getText());
		}
	}
	*/

}
