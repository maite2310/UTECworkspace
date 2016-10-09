package examenes.setiembre2016.parte3;

import java.util.LinkedList;

public class Principal {
	public static void main(String[] args){
		Mantenimiento mantenimiento1 = new Mantenimiento("Boeing 747", "Rotor arreglado", 3);
		Mantenimiento mantenimiento2 = new Mantenimiento("Boeing 737", "Mantenimiento", 5);
		
		LinkedList<Mantenimiento> man = new LinkedList<Mantenimiento>();
		man.add(mantenimiento1);
		man.add(mantenimiento1);
		
		Tecnico tecnico = new Tecnico();
		tecnico.cedula = "34432879";
		tecnico.nombre = "Jose Gonzalez";
		tecnico.mantenimientos = man;
		
	}
}
