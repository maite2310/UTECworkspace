package semana6.ejComplementarios;

public class Ejercicio4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Consultorio c= new Consultorio("1","Bvar Artigas 11111","Juan Rodriguez");
		Paciente p1 = new Paciente("Laura Fernandez","11111111");
		c.agregarPaciente(p1);
		Paciente p2 = new Paciente("Ricardo Gomez","22222222");
		c.agregarPaciente(p2);
		
		Paciente[] imprimir = c.listarPacientes();
		
		for (int i=0; i<imprimir.length; i++){
			System.out.println("Paciente "+i+": "+imprimir[i].getNombre());
		}
	}

}
