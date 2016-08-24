package com.java.windowbuilder;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(4, 2, 0, 0));
		
		JLabel lblNombre = new JLabel("Nombre");
		panel.add(lblNombre);
		
		textFieldNombre = new JTextField();
		panel.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		panel.add(lblApellido);
		
		textFieldApellido = new JTextField();
		panel.add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo");
		panel.add(lblSexo);
		
		JCheckBox chckbxFemenino = new JCheckBox("Femenino?");
		panel.add(chckbxFemenino);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Datos ingresados:");
	            System.out.println("Mi nombre es:" +textFieldNombre.getText());
	            System.out.println("Mi apellido es:" +textFieldApellido.getText());
	            System.out.println("Mi sexo es:" +(chckbxFemenino.isSelected()?"Femenino":"Masculino"));
			}
		});
		panel.add(btnGuardar);
	}
	
}
