package ej2_EmpleadoSuperior.ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ej2_EmpleadoSuperior.DAO.ManejadorSuperiores;
import ej2_EmpleadoSuperior.entidades.Superior;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class IngresarSuperior {

	private JFrame frame;
	private JTextField textNombre;
	private JTextField textCI;
	private JTextField textAñosTrab;
	private JLabel labelError;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IngresarSuperior window = new IngresarSuperior();
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
	public IngresarSuperior() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 48, 46, 14);
		frame.getContentPane().add(lblNombre);
		
		JLabel lblCi = new JLabel("CI");
		lblCi.setBounds(10, 91, 46, 14);
		frame.getContentPane().add(lblCi);
		
		JLabel lblAosTrabajados = new JLabel("A\u00F1os trabajados");
		lblAosTrabajados.setBounds(10, 130, 91, 14);
		frame.getContentPane().add(lblAosTrabajados);
		
		textNombre = new JTextField();
		textNombre.setBounds(106, 45, 86, 20);
		frame.getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		textCI = new JTextField();
		textCI.setBounds(106, 88, 86, 20);
		frame.getContentPane().add(textCI);
		textCI.setColumns(10);
		
		textAñosTrab = new JTextField();
		textAñosTrab.setBounds(106, 127, 86, 20);
		frame.getContentPane().add(textAñosTrab);
		textAñosTrab.setColumns(10);
		
		labelError = new JLabel("");
		labelError.setBounds(219, 202, 46, 14);
		frame.getContentPane().add(labelError);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					//Se crea nueva instancia de superior
					Superior superiorNuevo = new Superior();
					
					//Se obtienen los datos ingresados por el usuario
					String ci = textCI.getText();
					String nombre = textNombre.getText();
					int anios = Integer.parseInt( textAñosTrab.getText() );
					//Se setean los valores ingresados
					superiorNuevo.setCi(ci);
					superiorNuevo.setAñosDeTrabajo(anios);
					superiorNuevo.setNombre(nombre);
					//Se guarda nueva instancia en BD
					ManejadorSuperiores.guardarSuperior(superiorNuevo);
					
					//Si el insert se realizó correctamente se sigue en este código y se inicializan en vacio los textos
					labelError.setText("");					
					textAñosTrab.setText("");
					textCI.setText("");
					textNombre.setText("");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
					labelError.setText("Error insertando Superior en BD");
				}
				catch (Exception e){
					e.printStackTrace();
					labelError.setText("ERROR");
				}
			}
		});
		btnAceptar.setBounds(219, 227, 89, 23);
		frame.getContentPane().add(btnAceptar);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(8, 0, 426, 21);
		frame.getContentPane().add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmIngresarSuperior = new JMenuItem("Ingresar Superior");
		mnNewMenu.add(mntmIngresarSuperior);
		
		JMenuItem mntmIngresarEmpleado = new JMenuItem("Ingresar Empleado");
		mntmIngresarEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		mnNewMenu.add(mntmIngresarEmpleado);
		
		
	}
}
