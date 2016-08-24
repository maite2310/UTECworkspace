package semana7.tareaEstudiantes;


public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Persona p1 = new Persona ("Maria Perez", "44024677", "", "Uruguay", true);
		Persona p2 = new Persona ("Santiago Diaz", "", "", "Chile", true);
		Persona p3 = new Persona ("Jose Martin", "33786754", "AZA34579", "Uruguay", false);
		Persona p4 = new Persona ("Juan Rodriguez", "24568976", "CPA57564", "Uruguay", true);
		
		
		try{
			p1.puedeVotar (true);			
		}
		
		catch (NoVotaException ex){
			System.out.println(p1.getNombre() + " " +ex.getMessage());
			
		}
		
		try{
			p2.puedeVotar (true);
		}
		
		catch (NoVotaException ex){
			System.out.println( p2.getNombre() + " " + ex.getMessage());
			
		}
		
		try{
			p3.puedeVotar (false);
		}
		
		catch (NoVotaException ex){
			System.out.println(p3.getNombre() + " " +ex.getMessage());
			
		}
		
		try{
			p4.puedeVotar (true);
		}
		
		catch (NoVotaException ex){
			System.out.println(p4.getNombre() + " " +ex.getMessage());
		}
	}
}






