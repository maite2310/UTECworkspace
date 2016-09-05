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
	private JTextField textIdMateria;

	/**
	 * Create the panel.
	 */
	public altaMateria() {
		setLayout(null);
		
		textNombre = new JTextField();
		textNombre.setBounds(82, 67, 86, 20);
		add(textNombre);
		textNombre.setColumns(10);
		
		textIdMateria = new JTextField();
		textIdMateria.setBounds(82, 36, 86, 20);
		add(textIdMateria);
		textIdMateria.setColumns(10);
		

		JLabel labelError = new JLabel("");
		labelError.setForeground(Color.BLACK);
		labelError.setBounds(124, 172, 46, 14);
		add(labelError);
		
		JLabel lblNewLabel = new JLabel("Id");
		lblNewLabel.setBounds(26, 39, 46, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(26, 70, 46, 14);
		add(lblNewLabel_1);
		
		JLabel lblCarrera = new JLabel("Carrera");
		lblCarrera.setBounds(26, 108, 46, 14);
		add(lblCarrera);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(82, 105, 86, 20);
		add(comboBox);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Si algun cmpo es vacio se muestra mensaje
				if(textIdMateria.getText().isEmpty() || textNombre.getText().isEmpty())
					labelError.setText("Completar todos los campos");
				else{
					//si todos los campos están completos se sigue para el alta
					long idMateria = Long.parseLong( textIdMateria.getText()) ;
					String nombreMateria = textNombre.getText();
					String nombreCarrera = comboBox.getSelectedItem().toString();
					
					try{
						ControladorMaterias.crearMateria(idMateria, nombreMateria, nombreCarrera);
						labelError.setText("Ingreso exitoso");
						textIdMateria.setText("");
						textNombre.setText("");
					}
					catch(MateriaYaExistente e){
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
