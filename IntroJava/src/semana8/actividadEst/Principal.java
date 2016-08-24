package semana8.actividadEst;

import java.util.*;

public class Principal {

	public static void main(String[] args) {

		// ******CREACIÓN DE INSTANCIAS PARA SUCURSALES*********
		// En la última posición que debemos enviarle la lista de empleados le
		// enviamos NULL, dado que aún
		// no se han instanciado los mismos.
		Sucursal sucursal1 = new Sucursal("Casa Central", 1, "Montevideo", "28082888", "259142368838", null);
		Sucursal sucursal2 = new Sucursal("Sucursal Durazno", 3, "Durazno", "25823698", "248648282536", null);

		// ******CREACIÓN DE INSTANCIAS PARA EMPLEADOS JORNALEROS*********
		EmpJornalero jornalero1 = new EmpJornalero("Juan", "Zabala", 328672, 68, "Durazno", "26223858", 215.5, 120);
		EmpJornalero jornalero2 = new EmpJornalero("Pedro", "Rosen", 669825, 30, "Montevideo", "2852639", 280, 100.5);

		// ******CREACIÓN DE INSTANCIAS PARA EMPLEADOS MENSUALES*********
		EmpMensual mensual1 = new EmpMensual("Romina", "Paito", 333458, 50, "Durazno", "2528655", 38000, "Comercial");
		EmpMensual mensual2 = new EmpMensual("Lucas", "Manzi", 225698, 45, "Montevideo", "2887469", 38500, "Comercial");

		// Colección de Empleados para la Sucursal 1
		LinkedList<Empleado> colEmpleadosSuc1 = new LinkedList<Empleado>();
		colEmpleadosSuc1.add(jornalero2);
		colEmpleadosSuc1.add(mensual2);
		// Ahora que tenemos empleados asignados a la sucursal 1 modificamos el
		// valor de la variable que
		// habíamos definido como NULL
		sucursal1.colEmpleados = colEmpleadosSuc1;

		// Colección de Empleados para la Sucursal 2
		LinkedList<Empleado> colEmpleadosSuc2 = new LinkedList<Empleado>();
		colEmpleadosSuc2.add(jornalero1);
		colEmpleadosSuc2.add(mensual1);
		// Ahora que tenemos empleados asignados a la sucursal 2 modificamos el
		// valor de la variable que
		// habíamos definido como NULL
		sucursal2.colEmpleados = colEmpleadosSuc2;

		// CÁLCULO DEL IMPORTE A PAGAR POR CONCEPTO DE SUELDOS DE CADA SUCURSAL

		// SURCURSAL 1 - CASA CENTRAL
		LinkedList<Empleado> empSucursal1 = sucursal1.colEmpleados;
		double importeTotal = 0;
		for (Empleado unEmp : empSucursal1) {
			importeTotal += unEmp.getSueldo();
		}
		System.out.println("Gastos por conceptos de Sueldo Sucursal 1 - " + importeTotal);

		// SURCURSAL 2 - SUCURSAL DURAZNO
		LinkedList<Empleado> empSucursal2 = sucursal2.colEmpleados;
		double importeTotalB = 0;
		for (Empleado unEmp : empSucursal2) {
			importeTotalB += unEmp.getSueldo();
		}
		System.out.println("Gastos por conceptos de Sueldo Sucursal 2 - " + importeTotalB);
	}

}
