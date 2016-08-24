package examenes.repaso.ejercicio2.parte5;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;

public class Principal {
	public static void main(String[] args){
				
		Calendar cal = Calendar.getInstance();		
		cal.set(1980, Calendar.MAY, 25);
		Date fechaNac = cal.getTime();
				
		Socio socio1 = new SocioVitalicio("Pepe", fechaNac,null, 700, "cod22");
		
				
		Actividad actividad1 = new Actividad("gimnasia", "Juan", 2);
		Actividad actividad2 = new Actividad("futbol", "Maria", 3);
		Actividad actividad3 = new Actividad("tenis", "Paola", 1.5);
		
		LinkedList<Actividad> actividades = new LinkedList<>();
		actividades.add(actividad1);
		actividades.add(actividad2);
		actividades.add(actividad3);
		
		cal = Calendar.getInstance();
		Date hoy = cal.getTime();
		
		Socio socio2 = new SocioMensual("Ana", fechaNac,actividades, 700, hoy);
				
		LinkedList<Socio> socios = new LinkedList<>();
		socios.add(socio1);
		socios.add(socio2);
		
		for(Socio s : socios){
			try{
				
//				if(s instanceof SocioVitalicio){
//					SocioVitalicio socioVitalicio = (SocioVitalicio) s;
//					socioVitalicio.getProfesores();
//				}
				
				LinkedList<String> profesores = s.getProfesores();
				
				for(String p: profesores){
					System.out.println(p);
				}
				
			}
			catch(Exception e){
				System.out.println(s.getNombre() + ": "+ e.getMessage());
			}
			
		}
	}
}
