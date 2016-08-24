package com.java.swing;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class HolaMundo extends JFrame{

	public HolaMundo() {
	    JLabel texto = new JLabel( "Hola Mundo!" );
	    getContentPane().add( texto,"Center" );
	    setSize(300,200);
	}

	public static void main(String[] args) {
		HolaMundo ventana=new HolaMundo();
		ventana.setVisible(true);  //hago visible la ventana, sino no la vería
		ventana.setResizable(false); //no dejo que la ventana pueda cambiar de tamaño
	}
}
