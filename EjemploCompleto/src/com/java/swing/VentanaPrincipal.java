package com.java.swing;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaPrincipal {
	
	public VentanaPrincipal(){
		JButton botonAceptar = new JButton("Aceptar");
	    botonAceptar.setFont (new Font("Dialog",Font.BOLD,12));
	
	    JPanel panelSur = new JPanel (new BorderLayout());
	    panelSur.add (botonAceptar);
	
	    JLabel labelNombre = new JLabel();
	    labelNombre.setText ("Nombre:");
	    labelNombre.setBackground (new Color(255,255,204));
	   
	    JLabel labelEstudiante = new JLabel();
	    labelEstudiante.setText ("Estudiante:");
	    labelEstudiante.setBackground (new Color(255,255,204));
	
	    JPanel panelOeste = new JPanel (new GridLayout(2,1));
	    panelOeste.add (labelNombre);
	    panelOeste.add (labelEstudiante);
	
	    JTextField textFieldNombre = new JTextField();
	    JCheckBox chkboxEstudiante = new JCheckBox();
	    chkboxEstudiante.setText ("Es estudiante?");
	    chkboxEstudiante.setBackground (new Color(240,240,240));
	   
	    JPanel panelCentro = new JPanel (new GridLayout(2,1));
	    panelCentro.add (textFieldNombre);
	    panelCentro.add (chkboxEstudiante);
	
	
	    JFrame ventana = new JFrame ("Ingreso de datos");
	    ventana.setSize(450,200);
	    ventana.setLayout (new BorderLayout());
	    ventana.add (panelSur, BorderLayout.SOUTH);
	    ventana.add (panelOeste, BorderLayout.WEST);
	    ventana.add (panelCentro, BorderLayout.CENTER);
	    ventana.setVisible(true);
	    
	    //Registro evento para el aceptar
	    ActionListener manBoton = new ActionListener(){
	        public void actionPerformed (ActionEvent e){ 
	            System.out.println("Me hicieron click!");
	            System.out.println("Mi etiqueta es:" +e.getActionCommand());
	            System.out.println("Mi nombre es:" +textFieldNombre.getText());
	            System.out.println("Soy estudiante?:" +chkboxEstudiante.isSelected());
	        }
	    };

	    // lo registro como escucha del botón
	    botonAceptar.addActionListener(manBoton);

	}


	public static void main(String[] args) {
		VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();

	}

}
