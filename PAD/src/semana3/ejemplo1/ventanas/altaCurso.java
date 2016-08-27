package semana3.ejemplo1.ventanas;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import semana3.ejemplo1.DAO.DAOCursos;
import semana3.ejemplo1.entidades.Curso;

import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;

public class altaCurso extends JPanel {

	private JTextField idCurso;
	private JTextField idDocente;
	private JTextField idMateria;
	private JTextField fechaInicio;
	private JTextField fechaFin;
	private JTextField modalidad;
	
	/**
	 * Create the panel.
	 */
	public altaCurso() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Id Curso");
		lblNewLabel.setBounds(29, 48, 61, 14);
		add(lblNewLabel);
		
		JLabel lblIdDocente = new JLabel("Id Docente");
		lblIdDocente.setBounds(29, 85, 74, 14);
		add(lblIdDocente);
		
		JLabel lblIdMateria = new JLabel("Id Materia");
		lblIdMateria.setBounds(29, 129, 74, 14);
		add(lblIdMateria);
		
		JLabel lblFechaInicio = new JLabel("Fecha Inicio");
		lblFechaInicio.setBounds(211, 48, 74, 14);
		add(lblFechaInicio);
		
		JLabel lblFechaFin = new JLabel("Fecha Fin");
		lblFechaFin.setBounds(211, 85, 74, 14);
		add(lblFechaFin);
		
		JLabel lblModalidad = new JLabel("Modalidad");
		lblModalidad.setBounds(211, 129, 74, 14);
		add(lblModalidad);
		
		idCurso = new JTextField();
		idCurso.setBounds(88, 45, 86, 20);
		add(idCurso);
		idCurso.setColumns(10);
		
		idDocente = new JTextField();
		idDocente.setBounds(88, 82, 86, 20);
		add(idDocente);
		idDocente.setColumns(10);
		
		idMateria = new JTextField();
		idMateria.setBounds(88, 126, 86, 20);
		add(idMateria);
		idMateria.setColumns(10);
		
		fechaInicio = new JTextField();
		fechaInicio.setText("mm/dd/aaaa");
		fechaInicio.setBounds(284, 45, 86, 20);
		add(fechaInicio);
		fechaInicio.setColumns(10);
		
		fechaFin = new JTextField();
		fechaFin.setText("mm/dd/aaaa");
		fechaFin.setBounds(284, 82, 86, 20);
		add(fechaFin);
		fechaFin.setColumns(10);
		
		modalidad = new JTextField();
		modalidad.setBounds(284, 126, 86, 20);
		add(modalidad);
		modalidad.setColumns(10);
		
		JLabel textoMensaje = new JLabel("");
		textoMensaje.setBounds(74, 154, 211, 20);
		add(textoMensaje);
		
		JButton altaCurso = new JButton("Ingresar");
		altaCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					//Si se hace click en Ingresar, se tiene que guardar en la DB: para esto se crea un Curso y se llama al DAO
					
					long cursoId = Long.parseLong( idCurso.getText());
					long docenteId = Long.parseLong( idDocente.getText());
					long materiaId = Long.parseLong( idMateria.getText());
					String fechaIniStr = fechaInicio.getText();
					Date fechaIni = new Date(fechaIniStr);				
					String fechaFinStr = fechaFin.getText();
					Date fechaF = new Date(fechaFinStr);
					String modalidadCurso = modalidad.getText();
					
					
					//Creo curso
					Curso curso = new Curso(cursoId, docenteId, materiaId, fechaIni, fechaF, modalidadCurso);
					//Inserto el curso
					DAOCursos.insert(curso);
					textoMensaje.setText("Curso de id "+ cursoId +" creado con éxito");
				}
				catch(Exception exe){
					exe.printStackTrace();					
					textoMensaje.setText("ERROR: "+ exe.getMessage());
				}
			}
		});
		altaCurso.setBounds(284, 182, 89, 23);
		add(altaCurso);
		
		
	}

}
