package com.ipartek.formacion.uf1844.presentacion;

import java.awt.*;

import javax.swing.*;
import javax.swing.table.*;

import com.ipartek.formacion.uf1844.accesodatos.*;
import com.ipartek.formacion.uf1844.poo.pojos.*;
import java.awt.event.ActionListener;
import java.time.*;
import java.time.format.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MantenimientoOficinaSwing {

	private static final Dao<Persona> dao = DaoPersona.getInstancia();

	private static final Backupable<Persona> backupable = new BackupFichero<Persona>("personas.dat");

	private static DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	private DefaultTableModel modelo;

	private JFrame frame;
	private JTextField tfId;
	private JTextField tfNombre;
	private JTextField tfFecha;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MantenimientoOficinaSwing window = new MantenimientoOficinaSwing();
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
	public MantenimientoOficinaSwing() {
		initialize();

		// http://chuwiki.chuidiang.org/index.php?title=JTable
		modelo = (DefaultTableModel) table.getModel();
		modelo.addColumn("Id");
		modelo.addColumn("Nombre");
		modelo.addColumn("Fecha de nacimiento");

		restaurar();

		cargarTabla();

//				modelo.setValueAt("nuevo valor", 0, 1); // Cambia el valor de la fila 1, columna 2.
//				modelo.removeRow(0); // Borra la primera fila
	}

	private void restaurar() {
		Iterable<Persona> personas = backupable.restore();

		for (Persona p : personas) {
			dao.modificar(p); // dao.insertar(p);
			System.out.println(p);
		}
	}

	private void cargarTabla() {
		modelo.setRowCount(0);

		for (Persona p : dao.obtenerTodos()) {
			modelo.addRow(new Object[] { p.getId(), p.getNombre(), p.getFechaNacimiento() });
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, BorderLayout.SOUTH);
		
		JButton btnBackup = new JButton("Backup");
		btnBackup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backupable.backup(dao.obtenerTodos());
			}
		});
		panel_2.add(btnBackup);
		
		JButton btnRestore = new JButton("Restore");
		btnRestore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restaurar();
				
				cargarTabla();
			}
		});
		panel_2.add(btnRestore);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		frame.getContentPane().add(splitPane, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblId = new JLabel("Id");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 0;
		panel.add(lblId, gbc_lblId);

		tfId = new JTextField();
		GridBagConstraints gbc_tfId = new GridBagConstraints();
		gbc_tfId.insets = new Insets(0, 0, 5, 0);
		gbc_tfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfId.gridx = 1;
		gbc_tfId.gridy = 0;
		panel.add(tfId, gbc_tfId);
		tfId.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 1;
		panel.add(lblNombre, gbc_lblNombre);

		tfNombre = new JTextField();
		tfNombre.setColumns(10);
		GridBagConstraints gbc_tfNombre = new GridBagConstraints();
		gbc_tfNombre.insets = new Insets(0, 0, 5, 0);
		gbc_tfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfNombre.gridx = 1;
		gbc_tfNombre.gridy = 1;
		panel.add(tfNombre, gbc_tfNombre);

		JLabel lblFecha = new JLabel("Fecha de nacimiento");
		GridBagConstraints gbc_lblFecha = new GridBagConstraints();
		gbc_lblFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblFecha.insets = new Insets(0, 0, 5, 5);
		gbc_lblFecha.gridx = 0;
		gbc_lblFecha.gridy = 2;
		panel.add(lblFecha, gbc_lblFecha);

		tfFecha = new JTextField();
		tfFecha.setColumns(10);
		GridBagConstraints gbc_tfFecha = new GridBagConstraints();
		gbc_tfFecha.insets = new Insets(0, 0, 5, 0);
		gbc_tfFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfFecha.gridx = 1;
		gbc_tfFecha.gridy = 2;
		panel.add(tfFecha, gbc_tfFecha);
				
				JPanel panel_1 = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
				flowLayout.setAlignment(FlowLayout.LEFT);
				GridBagConstraints gbc_panel_1 = new GridBagConstraints();
				gbc_panel_1.insets = new Insets(0, 0, 5, 0);
				gbc_panel_1.fill = GridBagConstraints.BOTH;
				gbc_panel_1.gridx = 1;
				gbc_panel_1.gridy = 3;
				panel.add(panel_1, gbc_panel_1);
				
						JButton btnGuardar = new JButton("Guardar");
						panel_1.add(btnGuardar);
						
						JButton btnBorrar = new JButton("Borrar");
						btnBorrar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								Long id = Long.parseLong(tfId.getText());
								
								dao.borrar(id);
								
								cargarTabla();
							}
						});
						panel_1.add(btnBorrar);
				btnGuardar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Persona persona = new Persona();

						persona.setNombre(tfNombre.getText());
						persona.setFechaNacimiento(tfFecha.getText().length() > 0 ? LocalDate.parse(tfFecha.getText(), formatoFecha): null);

						if(tfId.getText() != null && tfId.getText().length() > 0) {
							persona.setId(Long.parseLong(tfId.getText()));					
							dao.modificar(persona);					
						} else {
							dao.insertar(persona);
						}

						cargarTabla();
					}
				});

		JScrollPane scrollPane = new JScrollPane();
		splitPane.setRightComponent(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int numeroFila = table.getSelectedRow();
				Long id = (Long)modelo.getValueAt(numeroFila, 0);
				
				Persona persona = dao.obtenerPorId(id);
				
				tfId.setText(persona.getId() != null ? persona.getId().toString() : "");
				tfNombre.setText(persona.getNombre() != null ? persona.getNombre() : "");
				tfFecha.setText(persona.getFechaNacimiento() != null ? formatoFecha.format(persona.getFechaNacimiento()): "");
			}
		});
		scrollPane.setViewportView(table);
	}

}
