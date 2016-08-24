package semana7.tareaEstudiantes;

public class NoVotaException extends Exception{
	
	public NoVotaException(String habilitado){
		super("No puede votar: ");	
	}
		
}
