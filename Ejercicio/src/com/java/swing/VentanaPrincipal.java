package com.java.swing;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaPrincipal {
	
	public VentanaPrincipal(){
		JButton botonAceptar = new JButton("Guardar");
	    botonAceptar.setFont (new Font("Dialog",Font.BOLD,12));
	
	    JPanel panelSur = new JPanel (new BorderLayout());
	    panelSur.add (botonAceptar);
	
	    JLabel labelNombre = new JLabel();
	    labelNombre.setText ("Nombre:");
	    labelNombre.setBackground (new Color(255,255,204));

	    JLabel labelApellido = new JLabel();
	    labelApellido.setText ("Apellido:");
	    labelApellido.setBackground (new Color(255,255,204));

	    JLabel labelSexo = new JLabel();
	    labelSexo.setText ("Sexo:");
	    labelSexo.setBackground (new Color(255,255,204));
	
	    JPanel panelOeste = new JPanel (new GridLayout(3,1));
	    panelOeste.add (labelNombre);
	    panelOeste.add (labelApellido);
	    panelOeste.add (labelSexo);
	
	    JTextField textFieldNombre = new JTextField();
	    JTextField textFieldApellido = new JTextField();
	    JCheckBox chkboxSexo = new JCheckBox();
	    chkboxSexo.setText ("Femenino?");
	    chkboxSexo.setBackground (new Color(240,240,240));
	   
	    JPanel panelCentro = new JPanel (new GridLayout(3,1));
	    panelCentro.add (textFieldNombre);
	    panelCentro.add (textFieldApellido);
	    panelCentro.add (chkboxSexo);
	
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
	            System.out.println("Datos ingresados:");
	            System.out.println("Mi nombre es:" +textFieldNombre.getText());
	            System.out.println("Mi apellido es:" +textFieldNombre.getText());
	            System.out.println("Mi sexo es:" +(chkboxSexo.isSelected()?"Femenino":"Masculino"));
	        }
	    };

	    // lo registro como escucha del botón
	    botonAceptar.addActionListener(manBoton);
	    
	    WindowAdapter manFrame = new WindowAdapter(){
	        public void windowClosing (WindowEvent e){ 
	            ventana.dispose(); // cierro el frame
	            System.exit(0); //termino la aplicación
	        }
	    };

	    // lo registro como escucha del frame
	    ventana.addWindowListener(manFrame);


	}


	public static void main(String[] args) {
		VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();

	}

}
