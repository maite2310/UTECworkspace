package semana3.ejemplo1.interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import semana3.ejemplo1.controladores.ControladorCarreras;
import semana3.ejemplo1.controladores.ControladorMaterias;
import semana3.ejemplo1.entidades.Materia;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class editarMateria extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					editarMateria frame = new editarMateria(1);
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
	public editarMateria(long idMateria) {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Se utiliza dispose_on_close para que no se termine la aplicación al cerrar el jframe
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 331, 244);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(23, 55, 46, 14);
		contentPane.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(97, 52, 160, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JComboBox comboBoxCarreras = new JComboBox();
		comboBoxCarreras.setBounds(97, 99, 160, 20);
		contentPane.add(comboBoxCarreras);
		
		JLabel lblCarrera = new JLabel("Carrera");
		lblCarrera.setBounds(23, 102, 46, 14);
		contentPane.add(lblCarrera);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(142, 159, 89, 23);
		contentPane.add(btnEditar);
		
		//agrego al combo los nombres de las carreras
		LinkedList<String> carreras = ControladorCarreras.obtenerNombreCarreras();
		for(String carrera : carreras){
			comboBoxCarreras.addItem(carrera);			
		}
		
		//Obtengo la materia de id el que me pasan por parámetro en el constructor
		Materia materia = ControladorMaterias.obtenerMateria(idMateria);
		comboBoxCarreras.setSelectedItem(materia.getCarrera().getNombre());
		textNombre.setText(materia.getNombre());
		
		//Si se hace click en editar se llama al controladorMaterias para editar la materia actual
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombreMateria = textNombre.getText();
				String nombreCarrera = comboBoxCarreras.getSelectedItem().toString();
			
				materia.setNombre(nombreMateria);
				ControladorMaterias.editarMateria(materia.getIdMateria(), nombreMateria, nombreCarrera);
				cerrarVentana();
			}
		});
		
		
	}
	
	public void cerrarVentana(){
		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		
		//this.setVisible(false);
	}
}
