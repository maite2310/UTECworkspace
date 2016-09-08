package semana3.ejemplo1.controladores;

import java.util.LinkedList;

import semana3.ejemplo1.DAO.DAOCarreras;
import semana3.ejemplo1.DAO.DAOMaterias;
import semana3.ejemplo1.entidades.Carrera;
import semana3.ejemplo1.entidades.Materia;
import semana3.ejemplo1.excepciones.MateriaYaExistente;

public class ControladorMaterias {
	
	public static boolean existeMateria(String nombre, String carrera){
		Materia materia = DAOMaterias.findByNombreAndCarrera(nombre, carrera);
		if(materia == null)
			return false;
		else
			return true;
	}
	
	public static boolean crearMateria(String nombre, String nombreCarrera) throws MateriaYaExistente {
		
		if(existeMateria(nombre, nombreCarrera)){
			throw new MateriaYaExistente("Ya existe la materia " + nombre + " para la carrera "+ nombreCarrera);
		}
		
		Carrera carrera = DAOCarreras.findByNombre(nombreCarrera);
		
		Materia materia = new Materia(nombre, carrera);
		return DAOMaterias.insert(materia);				
	}
	
	public static LinkedList<Materia> obtenerMaterias(){
		return DAOMaterias.findAll();
	}
}
