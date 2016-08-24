package semana5.teorico;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

/*
 *
 * Descripcion: Esta clase permite ingresar al usuario los numeros que han salido 
 * y los numeros jugados. Luego verifica cuantos fueron acertados, en caso que coincidan
 * todos le avisa al usuario que gano, en caso que al menos uno difiera le dice al usuario
 * que intente nuevamente.
 */
public class VerificaJugada extends JFrame {

	//Definicion de Constantes
	private static final String CTE_BOTON= "Ingresar Numeros";
	private static final String CTE_BOTON2= "Verificar Resulado";
	private static final String CTE_LABEL= "Numeros sorteados: ";
	private static final String CTE_LABEL2= "-";
	private static final String CTE_SUBJECT= "Verificando Jugada";
	private static final String CTE_JUGADA= "Ingrese su apuesta";
	private static final String CTE_ERR_MSG= "Debe ingresar numeros enteros en todos los valores";
	private static final String CTE_GANE= "Ganeeeeeee!!!!!!";
	private static final String CTE_PERDI= "No saque nada, será la próxima!!!!";
	
	
	
	//Definicion de atributos de la clase de Interfaz grafica
	private JTextField jText1,jText2, jText3, jText4, jText5, jText6;
	private JButton boton = new JButton (CTE_BOTON);
	private JButton boton2 = new JButton (CTE_BOTON2);
	private JLabel label1 = new JLabel (CTE_LABEL);
	private JLabel res = new JLabel();
	private JLabel label2 = new JLabel (CTE_LABEL2);
	
	//Atributos de la logica de negocios
	private int numeros [] = new int [6];
	private int apuesta [] = new int [5];
			

	
	/* 
	 * Descripcion: Inicializo los atributos y levanto el frame
	 */
	public VerificaJugada() {
		super(CTE_SUBJECT);
		Container container = getContentPane();
		container.setLayout(new FlowLayout());
		//Meteo los jtext en el container
		jText1 = new JTextField(2);
		jText2 = new JTextField(2);
		jText3 = new JTextField(2);
		jText4 = new JTextField(2);
		jText5 = new JTextField(2);
		jText6 = new JTextField(2);
		container.add(label1);
		container.add(jText1);
		container.add(jText2);
		container.add(jText3);
		container.add(jText4);
		container.add(jText5);
		label2 = new JLabel (CTE_LABEL2);
		container.add(label2);
		container.add(jText6);
		//Seteo la accion del boton
		boton.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	        validar();
	      }

		
	    });
		container.add(boton);
		
		setSize(500, 150);
		setVisible(true);
	}

	/*
	 *
	 * Fecha: 22-Jun-2016
	 * Descripcion: Validacion minima de la entrada ingresada por el usuario
	 */
	private void validar() {
		try {
			
			
			numeros[0]= (new Integer (jText1.getText())).intValue();
			numeros[1]= (new Integer (jText2.getText())).intValue();
			numeros[2]= (new Integer (jText3.getText())).intValue();
			numeros[3]= (new Integer (jText4.getText())).intValue();
			numeros[4]= (new Integer (jText5.getText())).intValue();
			numeros[5]= (new Integer (jText6.getText())).intValue();
			label1.setText(CTE_JUGADA);
			label2.setVisible(false);
			jText6.setVisible(false);
			jText1.setText("");
			jText2.setText("");
			jText3.setText("");
			jText4.setText("");
			jText5.setText("");
			boton.setVisible(false);
			
			Container container = getContentPane();
			//Seteo accion del boton2
			boton2.addActionListener(new ActionListener()
		    {
		      public void actionPerformed(ActionEvent e)
		      {
		        verificarResultado();
		      }

			
		    });
			container.add(boton2);
			container.add(res);
			
		}catch (Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, CTE_ERR_MSG);
		}
		
	}
	/*
	 * Fecha: 22-Jun-2016
	 * Descripcion: Verifica el resultado e imprime si gano o si debe jugar de nuevo
	 */
	private void verificarResultado() {
		try {
			
			
			apuesta[0]= (new Integer (jText1.getText())).intValue();
			apuesta[1]= (new Integer (jText2.getText())).intValue();
			apuesta[2]= (new Integer (jText3.getText())).intValue();
			apuesta[3]= (new Integer (jText4.getText())).intValue();
			apuesta[4]= (new Integer (jText5.getText())).intValue();
			int resultado = ganeOPerdi();
			
			switch (resultado){
				case 1: res.setText(CTE_GANE);
						break;
				default:res.setText(CTE_PERDI);
						
			}
			res.setFont(new Font("Serif", Font.BOLD, 18));
			res.setForeground(Color.RED);

			
			res.setAlignmentX(JLabel.CENTER);
			Border blackline = BorderFactory.createLineBorder(Color.black);
			res.setBorder(blackline);
			boton2.setEnabled(false);
			
		
			
		}catch (Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Debe ingresar numeros enteros en todos los valores");
		}
		
	}
	/*	 
	 * Fecha: 22-Jun-2016
	 * Descripcion: Devuelve 1 si emboque todos los numeros, cualquier otro valor
	 * en caso que al menos haya errado en 1
	 */
	private int ganeOPerdi(){
		System.out.println("Salieron 0:"+numeros[0]);
		System.out.println("Salieron 1:"+numeros[1]);
		System.out.println("Salieron 2:"+numeros[2]);
		System.out.println("Salieron 3:"+numeros[3]);
		System.out.println("Salieron 4:"+numeros[4]);
		System.out.println("Salieron 5:"+numeros[5]);
		
		System.out.println("Aposte 0:"+apuesta[0]);
		System.out.println("Aposte 1:"+apuesta[1]);
		System.out.println("Aposte 2:"+apuesta[2]);
		System.out.println("Aposte 3:"+apuesta[3]);
		System.out.println("Aposte 4:"+apuesta[4]);
		
		//el metodo devuelve el valor de gane:
		//gane es 0 si al menos un elemento de apuesta es distinto a su correspondiente en array de nombre numeros.
		//gane es 1 se todos los elementos de apuesta son iguales a su correspondiente en el array numeros
		int gane = 0;
		
		//Acá va la implementacion
		
		
		return gane;
	    
	}
	
	/*
	 * Descripcion: Metodo auxiliar que devuelve true si el numero esta 
	 * dentro de los que salieron
	 */
	private boolean estaEnNumeros (int num){
		boolean ret = false;
		for (int i=0; i<5;i++){
			if (num==numeros [i]){
				ret = true;
			}
		}
		return ret;
	}
	
	/*	 
	 * Fecha: 22-Jun-2016
	 * Descripcion: Metodo principal que levanta la ventana
	 */
	public static void main(String args[]) {
		VerificaJugada test = new VerificaJugada();
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

