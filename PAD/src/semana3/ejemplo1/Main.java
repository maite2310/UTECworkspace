package semana3.ejemplo1;

import semana3.ejemplo1.DAO.DAOCarreras;
import semana3.ejemplo1.DAO.DAOMateriasAnual;
import semana3.ejemplo1.entidades.Carrera;
import semana3.ejemplo1.entidades.MateriaAnual;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Carrera carrera = DAOCarreras.find(4);
		MateriaAnual ma = new MateriaAnual(1, "Teoria de Computación 5 Anual", carrera, true);
		
		DAOMateriasAnual.insert(ma);
		
		MateriaAnual m = DAOMateriasAnual.find(15);
	}

}
