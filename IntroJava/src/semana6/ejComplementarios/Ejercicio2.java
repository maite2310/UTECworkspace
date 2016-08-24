package semana6.ejComplementarios;

public class Ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Empleado e1 = new Empleado ("1","Juan","35485555");
		e1.setValorHora(200.5);
		
		e1.cargarHorasMes(1, 160);
		e1.cargarHorasMes(2, 140);
		e1.cargarHorasMes(3, 160);
		e1.cargarHorasMes(4, 150);
		e1.cargarHorasMes(5, 165);
		e1.cargarHorasMes(6, 170);
		
		Empleado e2 = new Empleado ("2","Paula","38887776");
		e2.setValorHora(250.5);
		
		e2.cargarHorasMes(1, 165);
		e2.cargarHorasMes(2, 135);
		e2.cargarHorasMes(3, 170);
		e2.cargarHorasMes(4, 145);
		e2.cargarHorasMes(5, 160);
		e2.cargarHorasMes(6, 165);
		
		System.out.println("Empleado 1:" +  e1.getNombre() + " Sueldo Junio: "+ e1.getSueldoMes(6));
		System.out.println("Empleado 2:" +  e2.getNombre() + " Sueldo Junio: "+ e2.getSueldoMes(6));
		
	}

}
