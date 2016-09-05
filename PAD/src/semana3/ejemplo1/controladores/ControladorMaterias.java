package semana3.ejemplo1.controladores;

import java.util.LinkedList;

import semana3.ejemplo1.DAO.DAOCarreras;
import semana3.ejemplo1.DAO.DAOMaterias;
import semana3.ejemplo1.entidades.Carrera;
import semana3.ejemplo1.entidades.Materia;
import semana3.ejemplo1.excepciones.MateriaYaExistente;

public class ControladorMaterias {
	
	public static boolean existeMateria(long idMateria){
		Materia materia = DAOMaterias.find(idMateria);
		if(materia == null)
			return false;
		else
			return true;
	}
	
	public static boolean crearMateria(long idMateria, String nombre, String nombreCarrera) throws MateriaYaExistente {
		
		if(existeMateria(idMateria)){
			throw new MateriaYaExistente("Ya existe la materia con id " + idMateria);
		}
		
		Carrera carrera = DAOCarreras.findByNombre(nombre);
		
		Materia materia = new Materia(idMateria, nombre, carrera);
		return DAOMaterias.insert(materia);				
	}
	
	public static LinkedList<Materia> obtenerMaterias(){
		return DAOMaterias.findAll();
	}
}
