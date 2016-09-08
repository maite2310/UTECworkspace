package semana3.ejemplo1.interfaz;

import javax.swing.JPanel;
import javax.swing.JTextField;

import semana3.ejemplo1.DAO.DAOCarreras;
import semana3.ejemplo1.controladores.ControladorCarreras;
import semana3.ejemplo1.controladores.ControladorMaterias;
import semana3.ejemplo1.entidades.Carrera;
import semana3.ejemplo1.excepciones.MateriaYaExistente;

import javax.swing.JLabel;

import java.util.LinkedList;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class altaMateria extends JPanel {
	private JTextField textNombre;

	/**
	 * Create the panel.
	 */
	public altaMateria() {
		setLayout(null);
		
		textNombre = new JTextField();
		textNombre.setBounds(82, 67, 191, 20);
		add(textNombre);
		textNombre.setColumns(10);
		

		JLabel labelError = new JLabel("");
		labelError.setForeground(Color.BLACK);
		labelError.setBounds(26, 172, 277, 14);
		add(labelError);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(26, 70, 46, 14);
		add(lblNewLabel_1);
		
		JLabel lblCarrera = new JLabel("Carrera");
		lblCarrera.setBounds(26, 108, 46, 14);
		add(lblCarrera);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(82, 105, 191, 20);
		add(comboBox);
		
		JButton btnIngresar = new JButton("Ingresar");
		//Al hacer click en ingrasar se llama al controladorMaterias para dar de alta una materia nueva
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Si algun cmpo es vacio se muestra mensaje
				if( textNombre.getText().isEmpty())
					labelError.setText("Completar todos los campos");
				else{
					//si todos los campos están completos se sigue para el alta					
					String nombreMateria = textNombre.getText();
					String nombreCarrera = comboBox.getSelectedItem().toString();
					
					try{
						ControladorMaterias.crearMateria(nombreMateria, nombreCarrera);
						//Si pasó la función crearMateria es que fue un ingreso exitoso
						labelError.setText("Ingreso exitoso");
						//Si inicializa el campo de nombre
						textNombre.setText("");
					}
					catch(Exception e){
						//Se muestra el mensaje de error
						labelError.setText(e.getMessage());
					}
				}
				
			}
		});
		btnIngresar.setBounds(184, 200, 89, 23);
		add(btnIngresar);
		
		//agrego al combo los nombres de las carreras
		LinkedList<String> carreras = ControladorCarreras.obtenerNombreCarreras();
		for(String carrera : carreras){
			comboBox.addItem(carrera);			
		}
		

	}
}
