package semana3.ejemplo1.controladores;

import java.util.LinkedList;

import semana3.ejemplo1.DAO.DAOCarreras;
import semana3.ejemplo1.entidades.Carrera;

public class ControladorCarreras {
	
	public static LinkedList<String> obtenerNombreCarreras(){
		LinkedList<String> nombres = new LinkedList<>();
		for(Carrera c : DAOCarreras.findAll()){
			nombres.add(c.getNombre());
		}		
		return nombres;		
	}
	
}
