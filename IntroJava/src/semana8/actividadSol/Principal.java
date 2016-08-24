package semana8.actividadSol;

import java.util.LinkedList;
import java.util.List;

public class Principal {

	public static void main (String [] args){
		Sucursal suc1 = new Sucursal();
		suc1.setNombre("Casa Central");
		suc1.setIdentificador(1);
		suc1.setDireccion("Montevideo");
		suc1.setTelefono("28082888");
		suc1.setRut("259142368838");
		
		Sucursal suc2 = new Sucursal();
		suc1.setNombre("Sucursal Durazno");
		suc1.setIdentificador(3);
		suc1.setDireccion("Durazno");
		suc1.setTelefono("25823698");
		suc1.setRut("248648282536");
		
		EmpJornalero j1 = new EmpJornalero("Juan", "Zabala", 328672, 68,"Durazno",  "26223858");
		j1.setValorHora(215.5);
		j1.setHorasTrabajadas(120);
		
		EmpJornalero j2 = new EmpJornalero("Pedro", "Rosen", 669825, 30,"Montevideo",  "2852639");
		j2.setValorHora(280);
		j2.setHorasTrabajadas(100.5);
		
		 List<Empleado> suc1Emp = new LinkedList<Empleado>();
		 suc1Emp.add(j2);
		 
		 List<Empleado> suc2Emp = new LinkedList<Empleado>();
		 suc2Emp.add(j1);
		 
		 EmpMensual m1 = new EmpMensual("Romina", "Paito", 333458, 50,"Durazno",  "2528655");
		 m1.setSalMensual(38000);
		 m1.setTipoRegimen("Comercial");
		 
		 EmpMensual m2 = new EmpMensual("Lucas", "Manzi", 225698, 45,"Montevideo",  "2887469");
		 m2.setSalMensual(38500);
		 m2.setTipoRegimen("Comercial");
		 
		 suc1Emp.add(m2);
		 suc2Emp.add(m1);
		 
		 suc1.setEmpleados(suc1Emp);
		 suc2.setEmpleados(suc2Emp);
		 
		 double aux =0;
		 
		 for (Empleado e: suc1.getEmpleados()){
			 aux = aux + e.getSueldo();
		 }
		 
		 System.out.println("Gastos por conceptos de Sueldo Sucursal 1 -"+aux );
		 
		 aux =0;
		 for (Empleado e: suc2.getEmpleados()){
			 aux = aux + e.getSueldo();
		 }
		 System.out.println("Gastos por conceptos de Sueldo Sucursal 2 -"+aux );
			
		 
	}
}
