package com.ipartek.formacion.uf1844.presentacion;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.*;

public class EjemploSwingDesigner {

	private JFrame frame;
	private JTextField tfNombre;
	private JLabel lblResultado;
	private JPanel panel;
	private JPanel panelComplejos;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;
	private JCheckBox chckbxNewCheckBox;
	private JToggleButton tglbtnNewToggleButton;
	private JButton btnCombo;
	@SuppressWarnings("rawtypes")
	private JList list;
	private JTable table;

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
			// UIManager.setLookAndFeel("com.sun.java." +
			// "swing.plaf.motif.MotifLookAndFeel");//
			// UIManager.getSystemLookAndFeelClassName());
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		initialize();

		// http://chuwiki.chuidiang.org/index.php?title=JTable
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.addColumn("etiqueta columna 1");
		modelo.addColumn("etiqueta columna 2");

		Object[] fila = new Object[2];
		fila[0] = "dato columna 1";
		fila[1] = "dato columna 2";
		modelo.addRow(fila); // Añade una fila al final
//		modelo.setValueAt("nuevo valor", 0, 1); // Cambia el valor de la fila 1, columna 2.
//		modelo.removeRow(0); // Borra la primera fila
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes", "serial" })
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 513, 503);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		panelComplejos = new JPanel();
		frame.getContentPane().add(panelComplejos, BorderLayout.CENTER);
		panelComplejos.setLayout(new GridLayout(0, 3, 0, 0));

		tglbtnNewToggleButton = new JToggleButton("New toggle button");
		panelComplejos.add(tglbtnNewToggleButton);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Rojo", "Verde", "Azul" }));
		panelComplejos.add(comboBox);

		btnCombo = new JButton("Ver combo");
		btnCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, comboBox.getSelectedItem());
			}
		});
		panelComplejos.add(btnCombo);

		list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] { "Uno", "Dos", "Tres" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		panelComplejos.add(list);

		chckbxNewCheckBox = new JCheckBox("New check box");
		panelComplejos.add(chckbxNewCheckBox);

		table = new JTable();
		panelComplejos.add(table);

		panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 261, 74, 0 };
		gbl_panel.rowHeights = new int[] { 34, 46, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, 1.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		tfNombre = new JTextField();
		tfNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				lblResultado.setText("Hola " + tfNombre.getText());
			}
		});
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

			@Override
			public void actionPerformed(ActionEvent e) {
				lblResultado.setText("Hola " + tfNombre.getText());
			}
		});

		lblResultado = new JLabel("");
		GridBagConstraints gbc_lblResultado = new GridBagConstraints();
		gbc_lblResultado.insets = new Insets(0, 0, 5, 0);
		gbc_lblResultado.gridwidth = 2;
		gbc_lblResultado.fill = GridBagConstraints.BOTH;
		gbc_lblResultado.gridx = 0;
		gbc_lblResultado.gridy = 1;
		panel.add(lblResultado, gbc_lblResultado);
		lblResultado.setHorizontalAlignment(SwingConstants.LEFT);
	}

}
